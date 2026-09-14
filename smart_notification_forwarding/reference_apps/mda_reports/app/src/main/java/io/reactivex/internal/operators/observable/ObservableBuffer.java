package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class ObservableBuffer<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {
    final int b;
    final int c;
    final Callable<U> d;

    /* loaded from: classes3.dex */
    static final class BufferExactObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {
        final Observer<? super U> a;
        final int b;
        final Callable<U> c;
        U d;
        int e;
        Disposable f;

        BufferExactObserver(Observer<? super U> observer, int i, Callable<U> callable) {
            this.a = observer;
            this.b = i;
            this.c = callable;
        }

        boolean a() {
            try {
                this.d = (U) ObjectHelper.requireNonNull(this.c.call(), "Empty buffer supplied");
                return true;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.d = null;
                Disposable disposable = this.f;
                if (disposable == null) {
                    EmptyDisposable.error(th, this.a);
                    return false;
                }
                disposable.dispose();
                this.a.onError(th);
                return false;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            U u = this.d;
            if (u != null) {
                this.d = null;
                if (!u.isEmpty()) {
                    this.a.onNext(u);
                }
                this.a.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.d = null;
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            U u = this.d;
            if (u != null) {
                u.add(t);
                int i = this.e + 1;
                this.e = i;
                if (i >= this.b) {
                    this.a.onNext(u);
                    this.e = 0;
                    a();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -8223395059921494546L;
        final Observer<? super U> a;
        final int b;
        final int c;
        final Callable<U> d;
        Disposable e;
        final ArrayDeque<U> f = new ArrayDeque<>();
        long g;

        BufferSkipObserver(Observer<? super U> observer, int i, int i2, Callable<U> callable) {
            this.a = observer;
            this.b = i;
            this.c = i2;
            this.d = callable;
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
            while (!this.f.isEmpty()) {
                this.a.onNext(this.f.poll());
            }
            this.a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f.clear();
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            long j = this.g;
            this.g = 1 + j;
            if (j % this.c == 0) {
                try {
                    this.f.offer((Collection) ObjectHelper.requireNonNull(this.d.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources."));
                } catch (Throwable th) {
                    this.f.clear();
                    this.e.dispose();
                    this.a.onError(th);
                    return;
                }
            }
            Iterator<U> it = this.f.iterator();
            while (it.hasNext()) {
                U next = it.next();
                next.add(t);
                if (this.b <= next.size()) {
                    it.remove();
                    this.a.onNext(next);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableBuffer(ObservableSource<T> observableSource, int i, int i2, Callable<U> callable) {
        super(observableSource);
        this.b = i;
        this.c = i2;
        this.d = callable;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super U> observer) {
        int i = this.c;
        int i2 = this.b;
        if (i != i2) {
            this.a.subscribe(new BufferSkipObserver(observer, i2, i, this.d));
            return;
        }
        BufferExactObserver bufferExactObserver = new BufferExactObserver(observer, i2, this.d);
        if (bufferExactObserver.a()) {
            this.a.subscribe(bufferExactObserver);
        }
    }
}
