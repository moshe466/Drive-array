package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableTimeoutTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final long c;
    final TimeUnit d;
    final Scheduler e;
    final Publisher<? extends T> f;

    /* loaded from: classes2.dex */
    static final class FallbackSubscriber<T> implements FlowableSubscriber<T> {
        final Subscriber<? super T> a;
        final SubscriptionArbiter b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public FallbackSubscriber(Subscriber<? super T> subscriber, SubscriptionArbiter subscriptionArbiter) {
            this.a = subscriber;
            this.b = subscriptionArbiter;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.b.setSubscription(subscription);
        }
    }

    /* loaded from: classes2.dex */
    static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T>, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;
        final Subscriber<? super T> h;
        final long i;
        final TimeUnit j;
        final Scheduler.Worker k;
        final SequentialDisposable l = new SequentialDisposable();
        final AtomicReference<Subscription> m = new AtomicReference<>();
        final AtomicLong n = new AtomicLong();
        long o;
        Publisher<? extends T> p;

        TimeoutFallbackSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler.Worker worker, Publisher<? extends T> publisher) {
            this.h = subscriber;
            this.i = j;
            this.j = timeUnit;
            this.k = worker;
            this.p = publisher;
        }

        void a(long j) {
            this.l.replace(this.k.schedule(new TimeoutTask(j, this), this.i, this.j));
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.k.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.n.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.l.dispose();
                this.h.onComplete();
                this.k.dispose();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.n.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.l.dispose();
            this.h.onError(th);
            this.k.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j = this.n.get();
            if (j != Long.MAX_VALUE) {
                long j2 = j + 1;
                if (this.n.compareAndSet(j, j2)) {
                    this.l.get().dispose();
                    this.o++;
                    this.h.onNext(t);
                    a(j2);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.m, subscription)) {
                setSubscription(subscription);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.TimeoutSupport
        public void onTimeout(long j) {
            if (this.n.compareAndSet(j, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.m);
                long j2 = this.o;
                if (j2 != 0) {
                    produced(j2);
                }
                Publisher<? extends T> publisher = this.p;
                this.p = null;
                publisher.subscribe(new FallbackSubscriber(this.h, this));
                this.k.dispose();
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class TimeoutSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;
        final Subscriber<? super T> a;
        final long b;
        final TimeUnit c;
        final Scheduler.Worker d;
        final SequentialDisposable e = new SequentialDisposable();
        final AtomicReference<Subscription> f = new AtomicReference<>();
        final AtomicLong g = new AtomicLong();

        TimeoutSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.a = subscriber;
            this.b = j;
            this.c = timeUnit;
            this.d = worker;
        }

        void a(long j) {
            this.e.replace(this.d.schedule(new TimeoutTask(j, this), this.b, this.c));
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.f);
            this.d.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.e.dispose();
                this.a.onComplete();
                this.d.dispose();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.e.dispose();
            this.a.onError(th);
            this.d.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j = get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    this.e.get().dispose();
                    this.a.onNext(t);
                    a(j2);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.f, this.g, subscription);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.TimeoutSupport
        public void onTimeout(long j) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.f);
                this.a.onError(new TimeoutException());
                this.d.dispose();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.f, this.g, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface TimeoutSupport {
        void onTimeout(long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class TimeoutTask implements Runnable {
        final TimeoutSupport a;
        final long b;

        TimeoutTask(long j, TimeoutSupport timeoutSupport) {
            this.b = j;
            this.a = timeoutSupport;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onTimeout(this.b);
        }
    }

    public FlowableTimeoutTimed(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, Publisher<? extends T> publisher) {
        super(flowable);
        this.c = j;
        this.d = timeUnit;
        this.e = scheduler;
        this.f = publisher;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        TimeoutFallbackSubscriber timeoutFallbackSubscriber;
        if (this.f == null) {
            TimeoutSubscriber timeoutSubscriber = new TimeoutSubscriber(subscriber, this.c, this.d, this.e.createWorker());
            subscriber.onSubscribe(timeoutSubscriber);
            timeoutSubscriber.a(0L);
            timeoutFallbackSubscriber = timeoutSubscriber;
        } else {
            TimeoutFallbackSubscriber timeoutFallbackSubscriber2 = new TimeoutFallbackSubscriber(subscriber, this.c, this.d, this.e.createWorker(), this.f);
            subscriber.onSubscribe(timeoutFallbackSubscriber2);
            timeoutFallbackSubscriber2.a(0L);
            timeoutFallbackSubscriber = timeoutFallbackSubscriber2;
        }
        this.b.subscribe((FlowableSubscriber) timeoutFallbackSubscriber);
    }
}
