package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.schedulers.Timed;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableTimeInterval<T> extends AbstractFlowableWithUpstream<T, Timed<T>> {
    final Scheduler c;
    final TimeUnit d;

    /* loaded from: classes2.dex */
    static final class TimeIntervalSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super Timed<T>> a;
        final TimeUnit b;
        final Scheduler c;
        Subscription d;
        long e;

        TimeIntervalSubscriber(Subscriber<? super Timed<T>> subscriber, TimeUnit timeUnit, Scheduler scheduler) {
            this.a = subscriber;
            this.c = scheduler;
            this.b = timeUnit;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.d.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long now = this.c.now(this.b);
            long j = this.e;
            this.e = now;
            this.a.onNext(new Timed(t, now - j, this.b));
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.e = this.c.now(this.b);
                this.d = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.d.request(j);
        }
    }

    public FlowableTimeInterval(Flowable<T> flowable, TimeUnit timeUnit, Scheduler scheduler) {
        super(flowable);
        this.c = scheduler;
        this.d = timeUnit;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super Timed<T>> subscriber) {
        this.b.subscribe((FlowableSubscriber) new TimeIntervalSubscriber(subscriber, this.d, this.c));
    }
}
