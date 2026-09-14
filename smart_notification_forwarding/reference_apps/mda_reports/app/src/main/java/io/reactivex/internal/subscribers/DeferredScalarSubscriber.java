package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes3.dex */
public abstract class DeferredScalarSubscriber<T, R> extends DeferredScalarSubscription<R> implements FlowableSubscriber<T> {
    private static final long serialVersionUID = 2984505488220891551L;
    protected Subscription c;
    protected boolean d;

    public DeferredScalarSubscriber(Subscriber<? super R> subscriber) {
        super(subscriber);
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public void cancel() {
        super.cancel();
        this.c.cancel();
    }

    public void onComplete() {
        if (this.d) {
            complete(this.b);
        } else {
            this.a.onComplete();
        }
    }

    public void onError(Throwable th) {
        this.b = null;
        this.a.onError(th);
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.c, subscription)) {
            this.c = subscription;
            this.a.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }
}
