package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableSingle<T> extends AbstractFlowableWithUpstream<T, T> {
    final T c;
    final boolean d;

    /* loaded from: classes2.dex */
    static final class SingleElementSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -5526049321428043809L;
        final T c;
        final boolean d;
        Subscription e;
        boolean f;

        SingleElementSubscriber(Subscriber<? super T> subscriber, T t, boolean z) {
            super(subscriber);
            this.c = t;
            this.d = z;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.e.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f) {
                return;
            }
            this.f = true;
            T t = this.b;
            this.b = null;
            if (t == null) {
                t = this.c;
            }
            if (t != null) {
                complete(t);
            } else if (this.d) {
                this.a.onError(new NoSuchElementException());
            } else {
                this.a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f) {
                RxJavaPlugins.onError(th);
            } else {
                this.f = true;
                this.a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f) {
                return;
            }
            if (this.b == null) {
                this.b = t;
                return;
            }
            this.f = true;
            this.e.cancel();
            this.a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                this.e = subscription;
                this.a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableSingle(Flowable<T> flowable, T t, boolean z) {
        super(flowable);
        this.c = t;
        this.d = z;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe((FlowableSubscriber) new SingleElementSubscriber(subscriber, this.c, this.d));
    }
}
