package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableTimeoutTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final long b;
    final TimeUnit c;
    final Scheduler d;
    final ObservableSource<? extends T> e;

    /* loaded from: classes3.dex */
    static final class FallbackObserver<T> implements Observer<T> {
        final Observer<? super T> a;
        final AtomicReference<Disposable> b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public FallbackObserver(Observer<? super T> observer, AtomicReference<Disposable> atomicReference) {
            this.a = observer;
            this.b = atomicReference;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.b, disposable);
        }
    }

    /* loaded from: classes3.dex */
    static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;
        final Observer<? super T> a;
        final long b;
        final TimeUnit c;
        final Scheduler.Worker d;
        final SequentialDisposable e = new SequentialDisposable();
        final AtomicLong f = new AtomicLong();
        final AtomicReference<Disposable> g = new AtomicReference<>();
        ObservableSource<? extends T> h;

        TimeoutFallbackObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler.Worker worker, ObservableSource<? extends T> observableSource) {
            this.a = observer;
            this.b = j;
            this.c = timeUnit;
            this.d = worker;
            this.h = observableSource;
        }

        void a(long j) {
            this.e.replace(this.d.schedule(new TimeoutTask(j, this), this.b, this.c));
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.g);
            DisposableHelper.dispose(this);
            this.d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.e.dispose();
                this.a.onComplete();
                this.d.dispose();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.e.dispose();
            this.a.onError(th);
            this.d.dispose();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            long j = this.f.get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (this.f.compareAndSet(j, j2)) {
                    this.e.get().dispose();
                    this.a.onNext(t);
                    a(j2);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.g, disposable);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.TimeoutSupport
        public void onTimeout(long j) {
            if (this.f.compareAndSet(j, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.g);
                ObservableSource<? extends T> observableSource = this.h;
                this.h = null;
                observableSource.subscribe(new FallbackObserver(this.a, this));
                this.d.dispose();
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class TimeoutObserver<T> extends AtomicLong implements Observer<T>, Disposable, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;
        final Observer<? super T> a;
        final long b;
        final TimeUnit c;
        final Scheduler.Worker d;
        final SequentialDisposable e = new SequentialDisposable();
        final AtomicReference<Disposable> f = new AtomicReference<>();

        TimeoutObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.a = observer;
            this.b = j;
            this.c = timeUnit;
            this.d = worker;
        }

        void a(long j) {
            this.e.replace(this.d.schedule(new TimeoutTask(j, this), this.b, this.c));
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.f);
            this.d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.e.dispose();
                this.a.onComplete();
                this.d.dispose();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.e.dispose();
            this.a.onError(th);
            this.d.dispose();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            long j = get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    this.e.get().dispose();
                    this.a.onNext(t);
                    a(j2);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f, disposable);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.TimeoutSupport
        public void onTimeout(long j) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.f);
                this.a.onError(new TimeoutException());
                this.d.dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface TimeoutSupport {
        void onTimeout(long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class TimeoutTask implements Runnable {
        final TimeoutSupport a;
        final long b;

        TimeoutTask(long j, TimeoutSupport timeoutSupport) {
            this.b = j;
            this.a = timeoutSupport;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onTimeout(this.b);
        }
    }

    public ObservableTimeoutTimed(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler, ObservableSource<? extends T> observableSource) {
        super(observable);
        this.b = j;
        this.c = timeUnit;
        this.d = scheduler;
        this.e = observableSource;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        TimeoutFallbackObserver timeoutFallbackObserver;
        if (this.e == null) {
            TimeoutObserver timeoutObserver = new TimeoutObserver(observer, this.b, this.c, this.d.createWorker());
            observer.onSubscribe(timeoutObserver);
            timeoutObserver.a(0L);
            timeoutFallbackObserver = timeoutObserver;
        } else {
            TimeoutFallbackObserver timeoutFallbackObserver2 = new TimeoutFallbackObserver(observer, this.b, this.c, this.d.createWorker(), this.e);
            observer.onSubscribe(timeoutFallbackObserver2);
            timeoutFallbackObserver2.a(0L);
            timeoutFallbackObserver = timeoutFallbackObserver2;
        }
        this.a.subscribe(timeoutFallbackObserver);
    }
}
