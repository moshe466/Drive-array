package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableIntervalRange extends Observable<Long> {
    final Scheduler a;
    final long b;
    final long c;
    final long d;
    final long e;
    final TimeUnit f;

    /* loaded from: classes3.dex */
    static final class IntervalRangeObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 1891866368734007884L;
        final Observer<? super Long> a;
        final long b;
        long c;

        IntervalRangeObserver(Observer<? super Long> observer, long j, long j2) {
            this.a = observer;
            this.c = j;
            this.b = j2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (isDisposed()) {
                return;
            }
            long j = this.c;
            this.a.onNext(Long.valueOf(j));
            if (j != this.b) {
                this.c = j + 1;
            } else {
                DisposableHelper.dispose(this);
                this.a.onComplete();
            }
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableIntervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, Scheduler scheduler) {
        this.d = j3;
        this.e = j4;
        this.f = timeUnit;
        this.a = scheduler;
        this.b = j;
        this.c = j2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Long> observer) {
        IntervalRangeObserver intervalRangeObserver = new IntervalRangeObserver(observer, this.b, this.c);
        observer.onSubscribe(intervalRangeObserver);
        Scheduler scheduler = this.a;
        if (!(scheduler instanceof TrampolineScheduler)) {
            intervalRangeObserver.setResource(scheduler.schedulePeriodicallyDirect(intervalRangeObserver, this.d, this.e, this.f));
            return;
        }
        Scheduler.Worker createWorker = scheduler.createWorker();
        intervalRangeObserver.setResource(createWorker);
        createWorker.schedulePeriodically(intervalRangeObserver, this.d, this.e, this.f);
    }
}
