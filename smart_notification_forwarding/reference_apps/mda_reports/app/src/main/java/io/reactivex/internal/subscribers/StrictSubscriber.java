package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes3.dex */
public class StrictSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = -4945028590049415624L;
    final Subscriber<? super T> a;
    final AtomicThrowable b = new AtomicThrowable();
    final AtomicLong c = new AtomicLong();
    final AtomicReference<Subscription> d = new AtomicReference<>();
    final AtomicBoolean e = new AtomicBoolean();
    volatile boolean f;

    public StrictSubscriber(Subscriber<? super T> subscriber) {
        this.a = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (this.f) {
            return;
        }
        SubscriptionHelper.cancel(this.d);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.f = true;
        HalfSerializer.onComplete(this.a, this, this.b);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.f = true;
        HalfSerializer.onError(this.a, th, this, this.b);
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        HalfSerializer.onNext(this.a, t, this, this.b);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (this.e.compareAndSet(false, true)) {
            this.a.onSubscribe(this);
            SubscriptionHelper.deferredSetOnce(this.d, this.c, subscription);
        } else {
            subscription.cancel();
            cancel();
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        if (j > 0) {
            SubscriptionHelper.deferredRequest(this.d, this.c, j);
            return;
        }
        cancel();
        onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j));
    }
}
