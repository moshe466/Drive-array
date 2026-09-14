package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableDelay<T> extends AbstractFlowableWithUpstream<T, T> {
    final long c;
    final TimeUnit d;
    final Scheduler e;
    final boolean f;

    /* loaded from: classes2.dex */
    static final class DelaySubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> a;
        final long b;
        final TimeUnit c;
        final Scheduler.Worker d;
        final boolean e;
        Subscription f;

        /* loaded from: classes2.dex */
        final class OnComplete implements Runnable {
            OnComplete() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelaySubscriber.this.a.onComplete();
                } finally {
                    DelaySubscriber.this.d.dispose();
                }
            }
        }

        /* loaded from: classes2.dex */
        final class OnError implements Runnable {
            private final Throwable t;

            OnError(Throwable th) {
                this.t = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelaySubscriber.this.a.onError(this.t);
                } finally {
                    DelaySubscriber.this.d.dispose();
                }
            }
        }

        /* loaded from: classes2.dex */
        final class OnNext implements Runnable {
            private final T t;

            OnNext(T t) {
                this.t = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                DelaySubscriber.this.a.onNext(this.t);
            }
        }

        DelaySubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler.Worker worker, boolean z) {
            this.a = subscriber;
            this.b = j;
            this.c = timeUnit;
            this.d = worker;
            this.e = z;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f.cancel();
            this.d.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.d.schedule(new OnComplete(), this.b, this.c);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.d.schedule(new OnError(th), this.e ? this.b : 0L, this.c);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.d.schedule(new OnNext(t), this.b, this.c);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.f.request(j);
        }
    }

    public FlowableDelay(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(flowable);
        this.c = j;
        this.d = timeUnit;
        this.e = scheduler;
        this.f = z;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe((FlowableSubscriber) new DelaySubscriber(this.f ? subscriber : new SerializedSubscriber(subscriber), this.c, this.d, this.e.createWorker(), this.f));
    }
}
