package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableTakeLast<T> extends AbstractFlowableWithUpstream<T, T> {
    final int c;

    /* loaded from: classes2.dex */
    static final class TakeLastSubscriber<T> extends ArrayDeque<T> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 7240042530241604978L;
        final Subscriber<? super T> a;
        final int b;
        Subscription c;
        volatile boolean d;
        volatile boolean e;
        final AtomicLong f = new AtomicLong();
        final AtomicInteger g = new AtomicInteger();

        TakeLastSubscriber(Subscriber<? super T> subscriber, int i) {
            this.a = subscriber;
            this.b = i;
        }

        void a() {
            if (this.g.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.a;
                long j = this.f.get();
                while (!this.e) {
                    if (this.d) {
                        long j2 = 0;
                        while (j2 != j) {
                            if (this.e) {
                                return;
                            }
                            T poll = poll();
                            if (poll == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onNext(poll);
                                j2++;
                            }
                        }
                        if (j2 != 0 && j != Long.MAX_VALUE) {
                            j = this.f.addAndGet(-j2);
                        }
                    }
                    if (this.g.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.e = true;
            this.c.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.d = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.b == size()) {
                poll();
            }
            offer(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                this.a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.f, j);
                a();
            }
        }
    }

    public FlowableTakeLast(Flowable<T> flowable, int i) {
        super(flowable);
        this.c = i;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe((FlowableSubscriber) new TakeLastSubscriber(subscriber, this.c));
    }
}
