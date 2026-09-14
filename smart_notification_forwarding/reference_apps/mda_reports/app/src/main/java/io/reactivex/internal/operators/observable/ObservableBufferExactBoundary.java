package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import java.util.Collection;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class ObservableBufferExactBoundary<T, U extends Collection<? super T>, B> extends AbstractObservableWithUpstream<T, U> {
    final ObservableSource<B> b;
    final Callable<U> c;

    /* loaded from: classes3.dex */
    static final class BufferBoundaryObserver<T, U extends Collection<? super T>, B> extends DisposableObserver<B> {
        final BufferExactBoundaryObserver<T, U, B> b;

        BufferBoundaryObserver(BufferExactBoundaryObserver<T, U, B> bufferExactBoundaryObserver) {
            this.b = bufferExactBoundaryObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.b.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.b.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(B b) {
            this.b.a();
        }
    }

    /* loaded from: classes3.dex */
    static final class BufferExactBoundaryObserver<T, U extends Collection<? super T>, B> extends QueueDrainObserver<T, U, U> implements Observer<T>, Disposable {
        final Callable<U> g;
        final ObservableSource<B> h;
        Disposable i;
        Disposable j;
        U k;

        BufferExactBoundaryObserver(Observer<? super U> observer, Callable<U> callable, ObservableSource<B> observableSource) {
            super(observer, new MpscLinkedQueue());
            this.g = callable;
            this.h = observableSource;
        }

        void a() {
            try {
                U u = (U) ObjectHelper.requireNonNull(this.g.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u2 = this.k;
                    if (u2 == null) {
                        return;
                    }
                    this.k = u;
                    a(u2, false, this);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                dispose();
                this.b.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public /* bridge */ /* synthetic */ void accept(Observer observer, Object obj) {
            accept((Observer<? super Observer>) observer, (Observer) obj);
        }

        public void accept(Observer<? super U> observer, U u) {
            this.b.onNext(u);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.d) {
                return;
            }
            this.d = true;
            this.j.dispose();
            this.i.dispose();
            if (enter()) {
                this.c.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            synchronized (this) {
                U u = this.k;
                if (u == null) {
                    return;
                }
                this.k = null;
                this.c.offer(u);
                this.e = true;
                if (enter()) {
                    QueueDrainHelper.drainLoop(this.c, this.b, false, this, this);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            dispose();
            this.b.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            synchronized (this) {
                U u = this.k;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.i, disposable)) {
                this.i = disposable;
                try {
                    this.k = (U) ObjectHelper.requireNonNull(this.g.call(), "The buffer supplied is null");
                    BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                    this.j = bufferBoundaryObserver;
                    this.b.onSubscribe(this);
                    if (this.d) {
                        return;
                    }
                    this.h.subscribe(bufferBoundaryObserver);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.d = true;
                    disposable.dispose();
                    EmptyDisposable.error(th, this.b);
                }
            }
        }
    }

    public ObservableBufferExactBoundary(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Callable<U> callable) {
        super(observableSource);
        this.b = observableSource2;
        this.c = callable;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super U> observer) {
        this.a.subscribe(new BufferExactBoundaryObserver(new SerializedObserver(observer), this.c, this.b));
    }
}
