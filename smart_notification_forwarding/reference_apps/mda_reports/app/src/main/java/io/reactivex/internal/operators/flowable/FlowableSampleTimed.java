package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableSampleTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final long c;
    final TimeUnit d;
    final Scheduler e;
    final boolean f;

    /* loaded from: classes2.dex */
    static final class SampleTimedEmitLast<T> extends SampleTimedSubscriber<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        final AtomicInteger h;

        SampleTimedEmitLast(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(subscriber, j, timeUnit, scheduler);
            this.h = new AtomicInteger(1);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSampleTimed.SampleTimedSubscriber
        void b() {
            c();
            if (this.h.decrementAndGet() == 0) {
                this.a.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.h.incrementAndGet() == 2) {
                c();
                if (this.h.decrementAndGet() == 0) {
                    this.a.onComplete();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class SampleTimedNoLast<T> extends SampleTimedSubscriber<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        SampleTimedNoLast(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(subscriber, j, timeUnit, scheduler);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSampleTimed.SampleTimedSubscriber
        void b() {
            this.a.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            c();
        }
    }

    /* loaded from: classes2.dex */
    static abstract class SampleTimedSubscriber<T> extends AtomicReference<T> implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        final Subscriber<? super T> a;
        final long b;
        final TimeUnit c;
        final Scheduler d;
        final AtomicLong e = new AtomicLong();
        final SequentialDisposable f = new SequentialDisposable();
        Subscription g;

        SampleTimedSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.a = subscriber;
            this.b = j;
            this.c = timeUnit;
            this.d = scheduler;
        }

        void a() {
            DisposableHelper.dispose(this.f);
        }

        abstract void b();

        void c() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                if (this.e.get() != 0) {
                    this.a.onNext(andSet);
                    BackpressureHelper.produced(this.e, 1L);
                } else {
                    cancel();
                    this.a.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            a();
            this.g.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            a();
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            a();
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.g, subscription)) {
                this.g = subscription;
                this.a.onSubscribe(this);
                SequentialDisposable sequentialDisposable = this.f;
                Scheduler scheduler = this.d;
                long j = this.b;
                sequentialDisposable.replace(scheduler.schedulePeriodicallyDirect(this, j, j, this.c));
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.e, j);
            }
        }
    }

    public FlowableSampleTimed(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(flowable);
        this.c = j;
        this.d = timeUnit;
        this.e = scheduler;
        this.f = z;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        Flowable<T> flowable;
        FlowableSubscriber<? super T> sampleTimedNoLast;
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        if (this.f) {
            flowable = this.b;
            sampleTimedNoLast = new SampleTimedEmitLast<>(serializedSubscriber, this.c, this.d, this.e);
        } else {
            flowable = this.b;
            sampleTimedNoLast = new SampleTimedNoLast<>(serializedSubscriber, this.c, this.d, this.e);
        }
        flowable.subscribe((FlowableSubscriber) sampleTimedNoLast);
    }
}
