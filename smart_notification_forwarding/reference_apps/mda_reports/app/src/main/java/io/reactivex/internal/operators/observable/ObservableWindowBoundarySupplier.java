package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableWindowBoundarySupplier<T, B> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final Callable<? extends ObservableSource<B>> b;
    final int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class WindowBoundaryInnerObserver<T, B> extends DisposableObserver<B> {
        final WindowBoundaryMainObserver<T, B> b;
        boolean c;

        WindowBoundaryInnerObserver(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.b = windowBoundaryMainObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.c) {
                return;
            }
            this.c = true;
            this.b.c();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.c) {
                RxJavaPlugins.onError(th);
            } else {
                this.c = true;
                this.b.a(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(B b) {
            if (this.c) {
                return;
            }
            this.c = true;
            dispose();
            this.b.a(this);
        }
    }

    /* loaded from: classes3.dex */
    static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        static final WindowBoundaryInnerObserver<Object, Object> l = new WindowBoundaryInnerObserver<>(null);
        static final Object m = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        final Observer<? super Observable<T>> a;
        final int b;
        final AtomicReference<WindowBoundaryInnerObserver<T, B>> c = new AtomicReference<>();
        final AtomicInteger d = new AtomicInteger(1);
        final MpscLinkedQueue<Object> e = new MpscLinkedQueue<>();
        final AtomicThrowable f = new AtomicThrowable();
        final AtomicBoolean g = new AtomicBoolean();
        final Callable<? extends ObservableSource<B>> h;
        Disposable i;
        volatile boolean j;
        UnicastSubject<T> k;

        WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, int i, Callable<? extends ObservableSource<B>> callable) {
            this.a = observer;
            this.b = i;
            this.h = callable;
        }

        void a() {
            Disposable disposable = (Disposable) this.c.getAndSet(l);
            if (disposable == null || disposable == l) {
                return;
            }
            disposable.dispose();
        }

        void a(WindowBoundaryInnerObserver<T, B> windowBoundaryInnerObserver) {
            this.c.compareAndSet(windowBoundaryInnerObserver, null);
            this.e.offer(m);
            b();
        }

        void a(Throwable th) {
            this.i.dispose();
            if (!this.f.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.j = true;
                b();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super Observable<T>> observer = this.a;
            MpscLinkedQueue<Object> mpscLinkedQueue = this.e;
            AtomicThrowable atomicThrowable = this.f;
            int i = 1;
            while (this.d.get() != 0) {
                UnicastSubject<T> unicastSubject = this.k;
                boolean z = this.j;
                if (z && atomicThrowable.get() != null) {
                    mpscLinkedQueue.clear();
                    Throwable terminate = atomicThrowable.terminate();
                    if (unicastSubject != 0) {
                        this.k = null;
                        unicastSubject.onError(terminate);
                    }
                    observer.onError(terminate);
                    return;
                }
                Object poll = mpscLinkedQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    Throwable terminate2 = atomicThrowable.terminate();
                    if (terminate2 == null) {
                        if (unicastSubject != 0) {
                            this.k = null;
                            unicastSubject.onComplete();
                        }
                        observer.onComplete();
                        return;
                    }
                    if (unicastSubject != 0) {
                        this.k = null;
                        unicastSubject.onError(terminate2);
                    }
                    observer.onError(terminate2);
                    return;
                }
                if (z2) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (poll != m) {
                    unicastSubject.onNext(poll);
                } else {
                    if (unicastSubject != 0) {
                        this.k = null;
                        unicastSubject.onComplete();
                    }
                    if (!this.g.get()) {
                        UnicastSubject<T> create = UnicastSubject.create(this.b, this);
                        this.k = create;
                        this.d.getAndIncrement();
                        try {
                            ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.h.call(), "The other Callable returned a null ObservableSource");
                            WindowBoundaryInnerObserver<T, B> windowBoundaryInnerObserver = new WindowBoundaryInnerObserver<>(this);
                            if (this.c.compareAndSet(null, windowBoundaryInnerObserver)) {
                                observableSource.subscribe(windowBoundaryInnerObserver);
                                observer.onNext(create);
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            atomicThrowable.addThrowable(th);
                            this.j = true;
                        }
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.k = null;
        }

        void c() {
            this.i.dispose();
            this.j = true;
            b();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.g.compareAndSet(false, true)) {
                a();
                if (this.d.decrementAndGet() == 0) {
                    this.i.dispose();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.g.get();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            a();
            this.j = true;
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            a();
            if (!this.f.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.j = true;
                b();
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.e.offer(t);
            b();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.i, disposable)) {
                this.i = disposable;
                this.a.onSubscribe(this);
                this.e.offer(m);
                b();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.d.decrementAndGet() == 0) {
                this.i.dispose();
            }
        }
    }

    public ObservableWindowBoundarySupplier(ObservableSource<T> observableSource, Callable<? extends ObservableSource<B>> callable, int i) {
        super(observableSource);
        this.b = callable;
        this.c = i;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        this.a.subscribe(new WindowBoundaryMainObserver(observer, this.c, this.b));
    }
}
