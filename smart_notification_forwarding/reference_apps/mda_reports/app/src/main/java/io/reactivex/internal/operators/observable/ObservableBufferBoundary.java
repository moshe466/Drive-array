package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractObservableWithUpstream<T, U> {
    final Callable<U> b;
    final ObservableSource<? extends Open> c;
    final Function<? super Open, ? extends ObservableSource<? extends Close>> d;

    /* loaded from: classes3.dex */
    static final class BufferBoundaryObserver<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -8466418554264089604L;
        final Observer<? super C> a;
        final Callable<C> b;
        final ObservableSource<? extends Open> c;
        final Function<? super Open, ? extends ObservableSource<? extends Close>> d;
        volatile boolean h;
        volatile boolean j;
        long k;
        final SpscLinkedArrayQueue<C> i = new SpscLinkedArrayQueue<>(Observable.bufferSize());
        final CompositeDisposable e = new CompositeDisposable();
        final AtomicReference<Disposable> f = new AtomicReference<>();
        Map<Long, C> l = new LinkedHashMap();
        final AtomicThrowable g = new AtomicThrowable();

        /* loaded from: classes3.dex */
        static final class BufferOpenObserver<Open> extends AtomicReference<Disposable> implements Observer<Open>, Disposable {
            private static final long serialVersionUID = -8498650778633225126L;
            final BufferBoundaryObserver<?, ?, Open, ?> a;

            BufferOpenObserver(BufferBoundaryObserver<?, ?, Open, ?> bufferBoundaryObserver) {
                this.a = bufferBoundaryObserver;
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return get() == DisposableHelper.DISPOSED;
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                lazySet(DisposableHelper.DISPOSED);
                this.a.a((BufferOpenObserver) this);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                lazySet(DisposableHelper.DISPOSED);
                this.a.a(this, th);
            }

            @Override // io.reactivex.Observer
            public void onNext(Open open) {
                this.a.a((BufferBoundaryObserver<?, ?, Open, ?>) open);
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        BufferBoundaryObserver(Observer<? super C> observer, ObservableSource<? extends Open> observableSource, Function<? super Open, ? extends ObservableSource<? extends Close>> function, Callable<C> callable) {
            this.a = observer;
            this.b = callable;
            this.c = observableSource;
            this.d = function;
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super C> observer = this.a;
            SpscLinkedArrayQueue<C> spscLinkedArrayQueue = this.i;
            int i = 1;
            while (!this.j) {
                boolean z = this.h;
                if (z && this.g.get() != null) {
                    spscLinkedArrayQueue.clear();
                    observer.onError(this.g.terminate());
                    return;
                }
                C poll = spscLinkedArrayQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    observer.onComplete();
                    return;
                } else if (z2) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    observer.onNext(poll);
                }
            }
            spscLinkedArrayQueue.clear();
        }

        void a(Disposable disposable, Throwable th) {
            DisposableHelper.dispose(this.f);
            this.e.delete(disposable);
            onError(th);
        }

        void a(BufferOpenObserver<Open> bufferOpenObserver) {
            this.e.delete(bufferOpenObserver);
            if (this.e.size() == 0) {
                DisposableHelper.dispose(this.f);
                this.h = true;
                a();
            }
        }

        void a(BufferCloseObserver<T, C> bufferCloseObserver, long j) {
            boolean z;
            this.e.delete(bufferCloseObserver);
            if (this.e.size() == 0) {
                DisposableHelper.dispose(this.f);
                z = true;
            } else {
                z = false;
            }
            synchronized (this) {
                if (this.l == null) {
                    return;
                }
                this.i.offer(this.l.remove(Long.valueOf(j)));
                if (z) {
                    this.h = true;
                }
                a();
            }
        }

        void a(Open open) {
            try {
                Collection collection = (Collection) ObjectHelper.requireNonNull(this.b.call(), "The bufferSupplier returned a null Collection");
                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.d.apply(open), "The bufferClose returned a null ObservableSource");
                long j = this.k;
                this.k = 1 + j;
                synchronized (this) {
                    Map<Long, C> map = this.l;
                    if (map == null) {
                        return;
                    }
                    map.put(Long.valueOf(j), collection);
                    BufferCloseObserver bufferCloseObserver = new BufferCloseObserver(this, j);
                    this.e.add(bufferCloseObserver);
                    observableSource.subscribe(bufferCloseObserver);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                DisposableHelper.dispose(this.f);
                onError(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (DisposableHelper.dispose(this.f)) {
                this.j = true;
                this.e.dispose();
                synchronized (this) {
                    this.l = null;
                }
                if (getAndIncrement() != 0) {
                    this.i.clear();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.e.dispose();
            synchronized (this) {
                Map<Long, C> map = this.l;
                if (map == null) {
                    return;
                }
                Iterator<C> it = map.values().iterator();
                while (it.hasNext()) {
                    this.i.offer(it.next());
                }
                this.l = null;
                this.h = true;
                a();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.g.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.e.dispose();
            synchronized (this) {
                this.l = null;
            }
            this.h = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            synchronized (this) {
                Map<Long, C> map = this.l;
                if (map == null) {
                    return;
                }
                Iterator<C> it = map.values().iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this.f, disposable)) {
                BufferOpenObserver bufferOpenObserver = new BufferOpenObserver(this);
                this.e.add(bufferOpenObserver);
                this.c.subscribe(bufferOpenObserver);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class BufferCloseObserver<T, C extends Collection<? super T>> extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = -8498650778633225126L;
        final BufferBoundaryObserver<T, C, ?, ?> a;
        final long b;

        BufferCloseObserver(BufferBoundaryObserver<T, C, ?, ?> bufferBoundaryObserver, long j) {
            this.a = bufferBoundaryObserver;
            this.b = j;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Disposable disposable = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                lazySet(disposableHelper);
                this.a.a(this, this.b);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Disposable disposable = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper) {
                RxJavaPlugins.onError(th);
            } else {
                lazySet(disposableHelper);
                this.a.a(this, th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            Disposable disposable = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                lazySet(disposableHelper);
                disposable.dispose();
                this.a.a(this, this.b);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableBufferBoundary(ObservableSource<T> observableSource, ObservableSource<? extends Open> observableSource2, Function<? super Open, ? extends ObservableSource<? extends Close>> function, Callable<U> callable) {
        super(observableSource);
        this.c = observableSource2;
        this.d = function;
        this.b = callable;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super U> observer) {
        BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(observer, this.c, this.d, this.b);
        observer.onSubscribe(bufferBoundaryObserver);
        this.a.subscribe(bufferBoundaryObserver);
    }
}
