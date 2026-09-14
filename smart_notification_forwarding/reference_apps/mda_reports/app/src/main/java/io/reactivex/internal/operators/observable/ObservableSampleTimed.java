package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableSampleTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final long b;
    final TimeUnit c;
    final Scheduler d;
    final boolean e;

    /* loaded from: classes3.dex */
    static final class SampleTimedEmitLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        final AtomicInteger g;

        SampleTimedEmitLast(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, j, timeUnit, scheduler);
            this.g = new AtomicInteger(1);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        void b() {
            c();
            if (this.g.decrementAndGet() == 0) {
                this.a.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.g.incrementAndGet() == 2) {
                c();
                if (this.g.decrementAndGet() == 0) {
                    this.a.onComplete();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class SampleTimedNoLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        SampleTimedNoLast(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, j, timeUnit, scheduler);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        void b() {
            this.a.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            c();
        }
    }

    /* loaded from: classes3.dex */
    static abstract class SampleTimedObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        final Observer<? super T> a;
        final long b;
        final TimeUnit c;
        final Scheduler d;
        final AtomicReference<Disposable> e = new AtomicReference<>();
        Disposable f;

        SampleTimedObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.a = observer;
            this.b = j;
            this.c = timeUnit;
            this.d = scheduler;
        }

        void a() {
            DisposableHelper.dispose(this.e);
        }

        abstract void b();

        void c() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.a.onNext(andSet);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            a();
            this.f.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            a();
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            a();
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                this.a.onSubscribe(this);
                Scheduler scheduler = this.d;
                long j = this.b;
                DisposableHelper.replace(this.e, scheduler.schedulePeriodicallyDirect(this, j, j, this.c));
            }
        }
    }

    public ObservableSampleTimed(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(observableSource);
        this.b = j;
        this.c = timeUnit;
        this.d = scheduler;
        this.e = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        ObservableSource<T> observableSource;
        Observer<? super T> sampleTimedNoLast;
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        if (this.e) {
            observableSource = this.a;
            sampleTimedNoLast = new SampleTimedEmitLast<>(serializedObserver, this.b, this.c, this.d);
        } else {
            observableSource = this.a;
            sampleTimedNoLast = new SampleTimedNoLast<>(serializedObserver, this.b, this.c, this.d);
        }
        observableSource.subscribe(sampleTimedNoLast);
    }
}
