package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public final class ObservableElementAt<T> extends AbstractObservableWithUpstream<T, T> {
    final long b;
    final T c;
    final boolean d;

    /* loaded from: classes3.dex */
    static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> a;
        final long b;
        final T c;
        final boolean d;
        Disposable e;
        long f;
        boolean g;

        ElementAtObserver(Observer<? super T> observer, long j, T t, boolean z) {
            this.a = observer;
            this.b = j;
            this.c = t;
            this.d = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.e.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.e.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.g) {
                return;
            }
            this.g = true;
            T t = this.c;
            if (t == null && this.d) {
                this.a.onError(new NoSuchElementException());
                return;
            }
            if (t != null) {
                this.a.onNext(t);
            }
            this.a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.g) {
                RxJavaPlugins.onError(th);
            } else {
                this.g = true;
                this.a.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.g) {
                return;
            }
            long j = this.f;
            if (j != this.b) {
                this.f = j + 1;
                return;
            }
            this.g = true;
            this.e.dispose();
            this.a.onNext(t);
            this.a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableElementAt(ObservableSource<T> observableSource, long j, T t, boolean z) {
        super(observableSource);
        this.b = j;
        this.c = t;
        this.d = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(new ElementAtObserver(observer, this.b, this.c, this.d));
    }
}
