package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableDelaySubscriptionOther<T, U> extends Flowable<T> {
    final Publisher<? extends T> b;
    final Publisher<U> c;

    /* loaded from: classes2.dex */
    final class DelaySubscriber implements FlowableSubscriber<U> {
        final SubscriptionArbiter a;
        final Subscriber<? super T> b;
        boolean c;

        /* loaded from: classes2.dex */
        final class DelaySubscription implements Subscription {
            private final Subscription s;

            DelaySubscription(DelaySubscriber delaySubscriber, Subscription subscription) {
                this.s = subscription;
            }

            @Override // org.reactivestreams.Subscription
            public void cancel() {
                this.s.cancel();
            }

            @Override // org.reactivestreams.Subscription
            public void request(long j) {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public final class OnCompleteSubscriber implements FlowableSubscriber<T> {
            OnCompleteSubscriber() {
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                DelaySubscriber.this.b.onComplete();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                DelaySubscriber.this.b.onError(th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(T t) {
                DelaySubscriber.this.b.onNext(t);
            }

            @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                DelaySubscriber.this.a.setSubscription(subscription);
            }
        }

        DelaySubscriber(SubscriptionArbiter subscriptionArbiter, Subscriber<? super T> subscriber) {
            this.a = subscriptionArbiter;
            this.b = subscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.c) {
                return;
            }
            this.c = true;
            FlowableDelaySubscriptionOther.this.b.subscribe(new OnCompleteSubscriber());
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.c) {
                RxJavaPlugins.onError(th);
            } else {
                this.c = true;
                this.b.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(U u) {
            onComplete();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.a.setSubscription(new DelaySubscription(this, subscription));
            subscription.request(Long.MAX_VALUE);
        }
    }

    public FlowableDelaySubscriptionOther(Publisher<? extends T> publisher, Publisher<U> publisher2) {
        this.b = publisher;
        this.c = publisher2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter();
        subscriber.onSubscribe(subscriptionArbiter);
        this.c.subscribe(new DelaySubscriber(subscriptionArbiter, subscriber));
    }
}
