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
public final class FlowableInterval extends Flowable<Long> {
    final Scheduler b;
    final long c;
    final long d;
    final TimeUnit e;

    /* loaded from: classes2.dex */
    static final class IntervalSubscriber extends AtomicLong implements Subscription, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final Subscriber<? super Long> a;
        long b;
        final AtomicReference<Disposable> c = new AtomicReference<>();

        IntervalSubscriber(Subscriber<? super Long> subscriber) {
            this.a = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            DisposableHelper.dispose(this.c);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this, j);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c.get() != DisposableHelper.DISPOSED) {
                long j = get();
                Subscriber<? super Long> subscriber = this.a;
                if (j != 0) {
                    long j2 = this.b;
                    this.b = j2 + 1;
                    subscriber.onNext(Long.valueOf(j2));
                    BackpressureHelper.produced(this, 1L);
                    return;
                }
                subscriber.onError(new MissingBackpressureException("Can't deliver value " + this.b + " due to lack of requests"));
                DisposableHelper.dispose(this.c);
            }
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.setOnce(this.c, disposable);
        }
    }

    public FlowableInterval(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.c = j;
        this.d = j2;
        this.e = timeUnit;
        this.b = scheduler;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Long> subscriber) {
        IntervalSubscriber intervalSubscriber = new IntervalSubscriber(subscriber);
        subscriber.onSubscribe(intervalSubscriber);
        Scheduler scheduler = this.b;
        if (!(scheduler instanceof TrampolineScheduler)) {
            intervalSubscriber.setResource(scheduler.schedulePeriodicallyDirect(intervalSubscriber, this.c, this.d, this.e));
            return;
        }
        Scheduler.Worker createWorker = scheduler.createWorker();
        intervalSubscriber.setResource(createWorker);
        createWorker.schedulePeriodically(intervalSubscriber, this.c, this.d, this.e);
    }
}
