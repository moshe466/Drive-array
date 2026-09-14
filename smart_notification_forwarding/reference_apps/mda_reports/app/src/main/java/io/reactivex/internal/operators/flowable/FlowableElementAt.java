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
public final class FlowableElementAt<T> extends AbstractFlowableWithUpstream<T, T> {
    final long c;
    final T d;
    final boolean e;

    /* loaded from: classes2.dex */
    static final class ElementAtSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 4066607327284737757L;
        final long c;
        final T d;
        final boolean e;
        Subscription f;
        long g;
        boolean h;

        ElementAtSubscriber(Subscriber<? super T> subscriber, long j, T t, boolean z) {
            super(subscriber);
            this.c = j;
            this.d = t;
            this.e = z;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.f.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.h) {
                return;
            }
            this.h = true;
            T t = this.d;
            if (t != null) {
                complete(t);
            } else if (this.e) {
                this.a.onError(new NoSuchElementException());
            } else {
                this.a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.h) {
                RxJavaPlugins.onError(th);
            } else {
                this.h = true;
                this.a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.h) {
                return;
            }
            long j = this.g;
            if (j != this.c) {
                this.g = j + 1;
                return;
            }
            this.h = true;
            this.f.cancel();
            complete(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                this.a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableElementAt(Flowable<T> flowable, long j, T t, boolean z) {
        super(flowable);
        this.c = j;
        this.d = t;
        this.e = z;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe((FlowableSubscriber) new ElementAtSubscriber(subscriber, this.c, this.d, this.e));
    }
}
