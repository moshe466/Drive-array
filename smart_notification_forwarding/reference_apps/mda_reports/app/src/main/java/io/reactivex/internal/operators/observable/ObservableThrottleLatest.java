package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Experimental
/* loaded from: classes3.dex */
public final class ObservableThrottleLatest<T> extends AbstractObservableWithUpstream<T, T> {
    final long b;
    final TimeUnit c;
    final Scheduler d;
    final boolean e;

    /* loaded from: classes3.dex */
    static final class ThrottleLatestObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;
        final Observer<? super T> a;
        final long b;
        final TimeUnit c;
        final Scheduler.Worker d;
        final boolean e;
        final AtomicReference<T> f = new AtomicReference<>();
        Disposable g;
        volatile boolean h;
        Throwable i;
        volatile boolean j;
        volatile boolean k;
        boolean l;

        ThrottleLatestObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler.Worker worker, boolean z) {
            this.a = observer;
            this.b = j;
            this.c = timeUnit;
            this.d = worker;
            this.e = z;
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicReference<T> atomicReference = this.f;
            Observer<? super T> observer = this.a;
            int i = 1;
            while (!this.j) {
                boolean z = this.h;
                if (!z || this.i == null) {
                    boolean z2 = atomicReference.get() == null;
                    if (z) {
                        T andSet = atomicReference.getAndSet(null);
                        if (!z2 && this.e) {
                            observer.onNext(andSet);
                        }
                        observer.onComplete();
                    } else {
                        if (z2) {
                            if (this.k) {
                                this.l = false;
                                this.k = false;
                            }
                        } else if (!this.l || this.k) {
                            observer.onNext(atomicReference.getAndSet(null));
                            this.k = false;
                            this.l = true;
                            this.d.schedule(this, this.b, this.c);
                        }
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    }
                } else {
                    atomicReference.lazySet(null);
                    observer.onError(this.i);
                }
                this.d.dispose();
                return;
            }
            atomicReference.lazySet(null);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.j = true;
            this.g.dispose();
            this.d.dispose();
            if (getAndIncrement() == 0) {
                this.f.lazySet(null);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.j;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.h = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.i = th;
            this.h = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.f.set(t);
            a();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.g, disposable)) {
                this.g = disposable;
                this.a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.k = true;
            a();
        }
    }

    public ObservableThrottleLatest(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(observable);
        this.b = j;
        this.c = timeUnit;
        this.d = scheduler;
        this.e = z;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(new ThrottleLatestObserver(observer, this.b, this.c, this.d.createWorker(), this.e));
    }
}
