package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes3.dex */
public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 7917814472626990048L;
    protected final Subscriber<? super R> a;
    protected Subscription b;
    protected R c;
    protected long d;

    public SinglePostCompleteSubscriber(Subscriber<? super R> subscriber) {
        this.a = subscriber;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(R r) {
        long j = this.d;
        if (j != 0) {
            BackpressureHelper.produced(this, j);
        }
        while (true) {
            long j2 = get();
            if ((j2 & Long.MIN_VALUE) != 0) {
                b(r);
                return;
            }
            if ((j2 & Long.MAX_VALUE) != 0) {
                lazySet(-9223372036854775807L);
                this.a.onNext(r);
                this.a.onComplete();
                return;
            } else {
                this.c = r;
                if (compareAndSet(0L, Long.MIN_VALUE)) {
                    return;
                } else {
                    this.c = null;
                }
            }
        }
    }

    protected void b(R r) {
    }

    public void cancel() {
        this.b.cancel();
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.b, subscription)) {
            this.b = subscription;
            this.a.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void request(long j) {
        long j2;
        if (!SubscriptionHelper.validate(j)) {
            return;
        }
        do {
            j2 = get();
            if ((j2 & Long.MIN_VALUE) != 0) {
                if (compareAndSet(Long.MIN_VALUE, -9223372036854775807L)) {
                    this.a.onNext(this.c);
                    this.a.onComplete();
                    return;
                }
                return;
            }
        } while (!compareAndSet(j2, BackpressureHelper.addCap(j2, j)));
        this.b.request(j);
    }
}
