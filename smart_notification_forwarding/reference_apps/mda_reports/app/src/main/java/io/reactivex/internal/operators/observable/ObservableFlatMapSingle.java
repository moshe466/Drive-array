package io.reactivex.internal.operators.observable;

import android.R;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableFlatMapSingle<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super T, ? extends SingleSource<? extends R>> b;
    final boolean c;

    /* loaded from: classes3.dex */
    static final class FlatMapSingleObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8600231336733376951L;
        final Observer<? super R> a;
        final boolean b;
        final Function<? super T, ? extends SingleSource<? extends R>> f;
        Disposable h;
        volatile boolean i;
        final CompositeDisposable c = new CompositeDisposable();
        final AtomicThrowable e = new AtomicThrowable();
        final AtomicInteger d = new AtomicInteger(1);
        final AtomicReference<SpscLinkedArrayQueue<R>> g = new AtomicReference<>();

        /* loaded from: classes3.dex */
        final class InnerObserver extends AtomicReference<Disposable> implements SingleObserver<R>, Disposable {
            private static final long serialVersionUID = -502562646270949838L;

            InnerObserver() {
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                FlatMapSingleObserver.this.a(this, th);
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(R r) {
                FlatMapSingleObserver.this.a((FlatMapSingleObserver<T, InnerObserver>.InnerObserver) this, (InnerObserver) r);
            }
        }

        FlatMapSingleObserver(Observer<? super R> observer, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
            this.a = observer;
            this.f = function;
            this.b = z;
        }

        void a() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.g.get();
            if (spscLinkedArrayQueue != null) {
                spscLinkedArrayQueue.clear();
            }
        }

        void a(FlatMapSingleObserver<T, R>.InnerObserver innerObserver, R r) {
            this.c.delete(innerObserver);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    this.a.onNext(r);
                    boolean z = this.d.decrementAndGet() == 0;
                    SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.g.get();
                    if (!z || (spscLinkedArrayQueue != null && !spscLinkedArrayQueue.isEmpty())) {
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        c();
                    } else {
                        Throwable terminate = this.e.terminate();
                        if (terminate != null) {
                            this.a.onError(terminate);
                            return;
                        } else {
                            this.a.onComplete();
                            return;
                        }
                    }
                }
            }
            SpscLinkedArrayQueue<R> d = d();
            synchronized (d) {
                d.offer(r);
            }
            this.d.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            c();
        }

        void a(FlatMapSingleObserver<T, R>.InnerObserver innerObserver, Throwable th) {
            this.c.delete(innerObserver);
            if (!this.e.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (!this.b) {
                this.h.dispose();
                this.c.dispose();
            }
            this.d.decrementAndGet();
            b();
        }

        void b() {
            if (getAndIncrement() == 0) {
                c();
            }
        }

        void c() {
            Observer<? super R> observer = this.a;
            AtomicInteger atomicInteger = this.d;
            AtomicReference<SpscLinkedArrayQueue<R>> atomicReference = this.g;
            int i = 1;
            while (!this.i) {
                if (!this.b && this.e.get() != null) {
                    Throwable terminate = this.e.terminate();
                    a();
                    observer.onError(terminate);
                    return;
                }
                boolean z = atomicInteger.get() == 0;
                SpscLinkedArrayQueue<R> spscLinkedArrayQueue = atomicReference.get();
                R.bool poll = spscLinkedArrayQueue != null ? spscLinkedArrayQueue.poll() : null;
                boolean z2 = poll == null;
                if (z && z2) {
                    Throwable terminate2 = this.e.terminate();
                    if (terminate2 != null) {
                        observer.onError(terminate2);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                }
                if (z2) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    observer.onNext(poll);
                }
            }
            a();
        }

        SpscLinkedArrayQueue<R> d() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue;
            do {
                SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = this.g.get();
                if (spscLinkedArrayQueue2 != null) {
                    return spscLinkedArrayQueue2;
                }
                spscLinkedArrayQueue = new SpscLinkedArrayQueue<>(Observable.bufferSize());
            } while (!this.g.compareAndSet(null, spscLinkedArrayQueue));
            return spscLinkedArrayQueue;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.i = true;
            this.h.dispose();
            this.c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.i;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.d.decrementAndGet();
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.d.decrementAndGet();
            if (!this.e.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (!this.b) {
                this.c.dispose();
            }
            b();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            try {
                SingleSource singleSource = (SingleSource) ObjectHelper.requireNonNull(this.f.apply(t), "The mapper returned a null SingleSource");
                this.d.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (this.i || !this.c.add(innerObserver)) {
                    return;
                }
                singleSource.subscribe(innerObserver);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.h.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.h, disposable)) {
                this.h = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapSingle(ObservableSource<T> observableSource, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        super(observableSource);
        this.b = function;
        this.c = z;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        this.a.subscribe(new FlatMapSingleObserver(observer, this.b, this.c));
    }
}
