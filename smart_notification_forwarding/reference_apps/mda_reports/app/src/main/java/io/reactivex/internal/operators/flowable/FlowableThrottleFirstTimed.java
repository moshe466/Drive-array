package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableThrottleFirstTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final long c;
    final TimeUnit d;
    final Scheduler e;

    /* loaded from: classes2.dex */
    static final class DebounceTimedSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -9102637559663639004L;
        final Subscriber<? super T> a;
        final long b;
        final TimeUnit c;
        final Scheduler.Worker d;
        Subscription e;
        final SequentialDisposable f = new SequentialDisposable();
        volatile boolean g;
        boolean h;

        DebounceTimedSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.a = subscriber;
            this.b = j;
            this.c = timeUnit;
            this.d = worker;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.e.cancel();
            this.d.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.h) {
                return;
            }
            this.h = true;
            this.a.onComplete();
            this.d.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.h) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.h = true;
            this.a.onError(th);
            this.d.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.h || this.g) {
                return;
            }
            this.g = true;
            if (get() == 0) {
                this.h = true;
                cancel();
                this.a.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
            } else {
                this.a.onNext(t);
                BackpressureHelper.produced(this, 1L);
                Disposable disposable = this.f.get();
                if (disposable != null) {
                    disposable.dispose();
                }
                this.f.replace(this.d.schedule(this, this.b, this.c));
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                this.e = subscription;
                this.a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this, j);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.g = false;
        }
    }

    public FlowableThrottleFirstTimed(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        super(flowable);
        this.c = j;
        this.d = timeUnit;
        this.e = scheduler;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe((FlowableSubscriber) new DebounceTimedSubscriber(new SerializedSubscriber(subscriber), this.c, this.d, this.e.createWorker()));
    }
}
