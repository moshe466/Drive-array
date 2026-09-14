package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableWindowBoundary<T, B> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final ObservableSource<B> b;
    final int c;

    /* loaded from: classes3.dex */
    static final class WindowBoundaryInnerObserver<T, B> extends DisposableObserver<B> {
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
            this.b.b();
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
            this.b.c();
        }
    }

    /* loaded from: classes3.dex */
    static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        static final Object k = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        final Observer<? super Observable<T>> a;
        final int b;
        final WindowBoundaryInnerObserver<T, B> c = new WindowBoundaryInnerObserver<>(this);
        final AtomicReference<Disposable> d = new AtomicReference<>();
        final AtomicInteger e = new AtomicInteger(1);
        final MpscLinkedQueue<Object> f = new MpscLinkedQueue<>();
        final AtomicThrowable g = new AtomicThrowable();
        final AtomicBoolean h = new AtomicBoolean();
        volatile boolean i;
        UnicastSubject<T> j;

        WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, int i) {
            this.a = observer;
            this.b = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super Observable<T>> observer = this.a;
            MpscLinkedQueue<Object> mpscLinkedQueue = this.f;
            AtomicThrowable atomicThrowable = this.g;
            int i = 1;
            while (this.e.get() != 0) {
                UnicastSubject<T> unicastSubject = this.j;
                boolean z = this.i;
                if (z && atomicThrowable.get() != null) {
                    mpscLinkedQueue.clear();
                    Throwable terminate = atomicThrowable.terminate();
                    if (unicastSubject != 0) {
                        this.j = null;
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
                            this.j = null;
                            unicastSubject.onComplete();
                        }
                        observer.onComplete();
                        return;
                    }
                    if (unicastSubject != 0) {
                        this.j = null;
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
                } else if (poll != k) {
                    unicastSubject.onNext(poll);
                } else {
                    if (unicastSubject != 0) {
                        this.j = null;
                        unicastSubject.onComplete();
                    }
                    if (!this.h.get()) {
                        UnicastSubject<T> create = UnicastSubject.create(this.b, this);
                        this.j = create;
                        this.e.getAndIncrement();
                        observer.onNext(create);
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.j = null;
        }

        void a(Throwable th) {
            DisposableHelper.dispose(this.d);
            if (!this.g.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.i = true;
                a();
            }
        }

        void b() {
            DisposableHelper.dispose(this.d);
            this.i = true;
            a();
        }

        void c() {
            this.f.offer(k);
            a();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.h.compareAndSet(false, true)) {
                this.c.dispose();
                if (this.e.decrementAndGet() == 0) {
                    DisposableHelper.dispose(this.d);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.h.get();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.c.dispose();
            this.i = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.c.dispose();
            if (!this.g.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.i = true;
                a();
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.f.offer(t);
            a();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this.d, disposable)) {
                c();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.e.decrementAndGet() == 0) {
                DisposableHelper.dispose(this.d);
            }
        }
    }

    public ObservableWindowBoundary(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, int i) {
        super(observableSource);
        this.b = observableSource2;
        this.c = i;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        WindowBoundaryMainObserver windowBoundaryMainObserver = new WindowBoundaryMainObserver(observer, this.c);
        observer.onSubscribe(windowBoundaryMainObserver);
        this.b.subscribe(windowBoundaryMainObserver.c);
        this.a.subscribe(windowBoundaryMainObserver);
    }
}
