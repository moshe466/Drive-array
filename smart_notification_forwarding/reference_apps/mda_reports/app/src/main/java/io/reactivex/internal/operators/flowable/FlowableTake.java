package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableTake<T> extends AbstractFlowableWithUpstream<T, T> {
    final long c;

    /* loaded from: classes2.dex */
    static final class TakeSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5636543848937116287L;
        boolean a;
        Subscription b;
        final Subscriber<? super T> c;
        final long d;
        long e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public TakeSubscriber(Subscriber<? super T> subscriber, long j) {
            this.c = subscriber;
            this.d = j;
            this.e = j;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.b.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.a) {
                return;
            }
            this.a = true;
            this.c.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.a) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.a = true;
            this.b.cancel();
            this.c.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.a) {
                return;
            }
            long j = this.e;
            this.e = j - 1;
            if (j > 0) {
                boolean z = this.e == 0;
                this.c.onNext(t);
                if (z) {
                    this.b.cancel();
                    onComplete();
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.b, subscription)) {
                this.b = subscription;
                if (this.d != 0) {
                    this.c.onSubscribe(this);
                    return;
                }
                subscription.cancel();
                this.a = true;
                EmptySubscription.complete(this.c);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                if (get() || !compareAndSet(false, true) || j < this.d) {
                    this.b.request(j);
                } else {
                    this.b.request(Long.MAX_VALUE);
                }
            }
        }
    }

    public FlowableTake(Flowable<T> flowable, long j) {
        super(flowable);
        this.c = j;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe((FlowableSubscriber) new TakeSubscriber(subscriber, this.c));
    }
}
