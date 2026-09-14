package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableIntervalRange extends Flowable<Long> {
    final Scheduler b;
    final long c;
    final long d;
    final long e;
    final long f;
    final TimeUnit g;

    /* loaded from: classes2.dex */
    static final class IntervalRangeSubscriber extends AtomicLong implements Subscription, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final Subscriber<? super Long> a;
        final long b;
        long c;
        final AtomicReference<Disposable> d = new AtomicReference<>();

        IntervalRangeSubscriber(Subscriber<? super Long> subscriber, long j, long j2) {
            this.a = subscriber;
            this.c = j;
            this.b = j2;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            DisposableHelper.dispose(this.d);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this, j);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.d.get() != DisposableHelper.DISPOSED) {
                long j = get();
                if (j == 0) {
                    this.a.onError(new MissingBackpressureException("Can't deliver value " + this.c + " due to lack of requests"));
                    DisposableHelper.dispose(this.d);
                    return;
                }
                long j2 = this.c;
                this.a.onNext(Long.valueOf(j2));
                if (j2 == this.b) {
                    if (this.d.get() != DisposableHelper.DISPOSED) {
                        this.a.onComplete();
                    }
                    DisposableHelper.dispose(this.d);
                } else {
                    this.c = j2 + 1;
                    if (j != Long.MAX_VALUE) {
                        decrementAndGet();
                    }
                }
            }
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.setOnce(this.d, disposable);
        }
    }

    public FlowableIntervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, Scheduler scheduler) {
        this.e = j3;
        this.f = j4;
        this.g = timeUnit;
        this.b = scheduler;
        this.c = j;
        this.d = j2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Long> subscriber) {
        IntervalRangeSubscriber intervalRangeSubscriber = new IntervalRangeSubscriber(subscriber, this.c, this.d);
        subscriber.onSubscribe(intervalRangeSubscriber);
        Scheduler scheduler = this.b;
        if (!(scheduler instanceof TrampolineScheduler)) {
            intervalRangeSubscriber.setResource(scheduler.schedulePeriodicallyDirect(intervalRangeSubscriber, this.e, this.f, this.g));
            return;
        }
        Scheduler.Worker createWorker = scheduler.createWorker();
        intervalRangeSubscriber.setResource(createWorker);
        createWorker.schedulePeriodically(intervalRangeSubscriber, this.e, this.f, this.g);
    }
}
