package io.reactivex.internal.subscribers;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

/* loaded from: classes3.dex */
public abstract class BasicFuseableConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, QueueSubscription<R> {
    protected final ConditionalSubscriber<? super R> a;
    protected Subscription b;
    protected QueueSubscription<T> c;
    protected boolean d;
    protected int e;

    public BasicFuseableConditionalSubscriber(ConditionalSubscriber<? super R> conditionalSubscriber) {
        this.a = conditionalSubscriber;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(int i) {
        QueueSubscription<T> queueSubscription = this.c;
        if (queueSubscription == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = queueSubscription.requestFusion(i);
        if (requestFusion != 0) {
            this.e = requestFusion;
        }
        return requestFusion;
    }

    protected void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Throwable th) {
        Exceptions.throwIfFatal(th);
        this.b.cancel();
        onError(th);
    }

    protected boolean b() {
        return true;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.b.cancel();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        this.c.clear();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(R r, R r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.a.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.d) {
            RxJavaPlugins.onError(th);
        } else {
            this.d = true;
            this.a.onError(th);
        }
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.b, subscription)) {
            this.b = subscription;
            if (subscription instanceof QueueSubscription) {
                this.c = (QueueSubscription) subscription;
            }
            if (b()) {
                this.a.onSubscribe(this);
                a();
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        this.b.request(j);
    }
}
