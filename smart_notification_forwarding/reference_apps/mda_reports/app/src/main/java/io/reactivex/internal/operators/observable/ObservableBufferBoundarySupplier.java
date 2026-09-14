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
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableBufferBoundarySupplier<T, U extends Collection<? super T>, B> extends AbstractObservableWithUpstream<T, U> {
    final Callable<? extends ObservableSource<B>> b;
    final Callable<U> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class BufferBoundaryObserver<T, U extends Collection<? super T>, B> extends DisposableObserver<B> {
        final BufferBoundarySupplierObserver<T, U, B> b;
        boolean c;

        BufferBoundaryObserver(BufferBoundarySupplierObserver<T, U, B> bufferBoundarySupplierObserver) {
            this.b = bufferBoundarySupplierObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.c) {
                return;
            }
            this.c = true;
            this.b.b();
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
        public void onNext(B b) {
            if (this.c) {
                return;
            }
            this.c = true;
            dispose();
            this.b.b();
        }
    }

    /* loaded from: classes3.dex */
    static final class BufferBoundarySupplierObserver<T, U extends Collection<? super T>, B> extends QueueDrainObserver<T, U, U> implements Observer<T>, Disposable {
        final Callable<U> g;
        final Callable<? extends ObservableSource<B>> h;
        Disposable i;
        final AtomicReference<Disposable> j;
        U k;

        BufferBoundarySupplierObserver(Observer<? super U> observer, Callable<U> callable, Callable<? extends ObservableSource<B>> callable2) {
            super(observer, new MpscLinkedQueue());
            this.j = new AtomicReference<>();
            this.g = callable;
            this.h = callable2;
        }

        void a() {
            DisposableHelper.dispose(this.j);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public /* bridge */ /* synthetic */ void accept(Observer observer, Object obj) {
            accept((Observer<? super Observer>) observer, (Observer) obj);
        }

        public void accept(Observer<? super U> observer, U u) {
            this.b.onNext(u);
        }

        void b() {
            U u;
            try {
                u = (U) ObjectHelper.requireNonNull(this.g.call(), "The buffer supplied is null");
            } catch (Throwable th) {
                th = th;
                Exceptions.throwIfFatal(th);
                dispose();
            }
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.h.call(), "The boundary ObservableSource supplied is null");
                BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                if (DisposableHelper.replace(this.j, bufferBoundaryObserver)) {
                    synchronized (this) {
                        U u2 = this.k;
                        if (u2 == null) {
                            return;
                        }
                        this.k = u;
                        observableSource.subscribe(bufferBoundaryObserver);
                        a(u2, false, this);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                Exceptions.throwIfFatal(th);
                this.d = true;
                this.i.dispose();
                this.b.onError(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.d) {
                return;
            }
            this.d = true;
            this.i.dispose();
            a();
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
                Observer<? super V> observer = this.b;
                try {
                    this.k = (U) ObjectHelper.requireNonNull(this.g.call(), "The buffer supplied is null");
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.h.call(), "The boundary ObservableSource supplied is null");
                    BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                    this.j.set(bufferBoundaryObserver);
                    observer.onSubscribe(this);
                    if (this.d) {
                        return;
                    }
                    observableSource.subscribe(bufferBoundaryObserver);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.d = true;
                    disposable.dispose();
                    EmptyDisposable.error(th, observer);
                }
            }
        }
    }

    public ObservableBufferBoundarySupplier(ObservableSource<T> observableSource, Callable<? extends ObservableSource<B>> callable, Callable<U> callable2) {
        super(observableSource);
        this.b = callable;
        this.c = callable2;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super U> observer) {
        this.a.subscribe(new BufferBoundarySupplierObserver(new SerializedObserver(observer), this.c, this.b));
    }
}
