package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.annotations.Experimental;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Experimental
/* loaded from: classes2.dex */
public final class FlowableThrottleLatest<T> extends AbstractFlowableWithUpstream<T, T> {
    final long c;
    final TimeUnit d;
    final Scheduler e;
    final boolean f;

    /* loaded from: classes2.dex */
    static final class ThrottleLatestSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;
        final Subscriber<? super T> a;
        final long b;
        final TimeUnit c;
        final Scheduler.Worker d;
        final boolean e;
        final AtomicReference<T> f = new AtomicReference<>();
        final AtomicLong g = new AtomicLong();
        Subscription h;
        volatile boolean i;
        Throwable j;
        volatile boolean k;
        volatile boolean l;
        long m;
        boolean n;

        ThrottleLatestSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler.Worker worker, boolean z) {
            this.a = subscriber;
            this.b = j;
            this.c = timeUnit;
            this.d = worker;
            this.e = z;
        }

        void a() {
            Throwable missingBackpressureException;
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicReference<T> atomicReference = this.f;
            AtomicLong atomicLong = this.g;
            Subscriber<? super T> subscriber = this.a;
            int i = 1;
            while (!this.k) {
                boolean z = this.i;
                if (!z || this.j == null) {
                    boolean z2 = atomicReference.get() == null;
                    if (z) {
                        if (z2 || !this.e) {
                            atomicReference.lazySet(null);
                        } else {
                            T andSet = atomicReference.getAndSet(null);
                            long j = this.m;
                            if (j != atomicLong.get()) {
                                this.m = j + 1;
                                subscriber.onNext(andSet);
                            } else {
                                missingBackpressureException = new MissingBackpressureException("Could not emit final value due to lack of requests");
                            }
                        }
                        subscriber.onComplete();
                        this.d.dispose();
                        return;
                    }
                    if (z2) {
                        if (this.l) {
                            this.n = false;
                            this.l = false;
                        }
                    } else if (!this.n || this.l) {
                        T andSet2 = atomicReference.getAndSet(null);
                        long j2 = this.m;
                        if (j2 != atomicLong.get()) {
                            subscriber.onNext(andSet2);
                            this.m = j2 + 1;
                            this.l = false;
                            this.n = true;
                            this.d.schedule(this, this.b, this.c);
                        } else {
                            this.h.cancel();
                            missingBackpressureException = new MissingBackpressureException("Could not emit value due to lack of requests");
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    atomicReference.lazySet(null);
                    missingBackpressureException = this.j;
                }
                subscriber.onError(missingBackpressureException);
                this.d.dispose();
                return;
            }
            atomicReference.lazySet(null);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.k = true;
            this.h.cancel();
            this.d.dispose();
            if (getAndIncrement() == 0) {
                this.f.lazySet(null);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.i = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.j = th;
            this.i = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.f.set(t);
            a();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.h, subscription)) {
                this.h = subscription;
                this.a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.g, j);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.l = true;
            a();
        }
    }

    public FlowableThrottleLatest(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(flowable);
        this.c = j;
        this.d = timeUnit;
        this.e = scheduler;
        this.f = z;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe((FlowableSubscriber) new ThrottleLatestSubscriber(subscriber, this.c, this.d, this.e.createWorker(), this.f));
    }
}
