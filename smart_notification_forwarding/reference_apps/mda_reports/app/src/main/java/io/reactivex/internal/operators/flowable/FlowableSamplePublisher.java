package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableSamplePublisher<T> extends Flowable<T> {
    final Publisher<T> b;
    final Publisher<?> c;
    final boolean d;

    /* loaded from: classes2.dex */
    static final class SampleMainEmitLast<T> extends SamplePublisherSubscriber<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        final AtomicInteger f;
        volatile boolean g;

        SampleMainEmitLast(Subscriber<? super T> subscriber, Publisher<?> publisher) {
            super(subscriber, publisher);
            this.f = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void a() {
            this.g = true;
            if (this.f.getAndIncrement() == 0) {
                c();
                this.a.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void b() {
            this.g = true;
            if (this.f.getAndIncrement() == 0) {
                c();
                this.a.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void d() {
            if (this.f.getAndIncrement() != 0) {
                return;
            }
            do {
                boolean z = this.g;
                c();
                if (z) {
                    this.a.onComplete();
                    return;
                }
            } while (this.f.decrementAndGet() != 0);
        }
    }

    /* loaded from: classes2.dex */
    static final class SampleMainNoLast<T> extends SamplePublisherSubscriber<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        SampleMainNoLast(Subscriber<? super T> subscriber, Publisher<?> publisher) {
            super(subscriber, publisher);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void a() {
            this.a.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void b() {
            this.a.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void d() {
            c();
        }
    }

    /* loaded from: classes2.dex */
    static abstract class SamplePublisherSubscriber<T> extends AtomicReference<T> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -3517602651313910099L;
        final Subscriber<? super T> a;
        final Publisher<?> b;
        final AtomicLong c = new AtomicLong();
        final AtomicReference<Subscription> d = new AtomicReference<>();
        Subscription e;

        SamplePublisherSubscriber(Subscriber<? super T> subscriber, Publisher<?> publisher) {
            this.a = subscriber;
            this.b = publisher;
        }

        abstract void a();

        void a(Subscription subscription) {
            SubscriptionHelper.setOnce(this.d, subscription, Long.MAX_VALUE);
        }

        abstract void b();

        void c() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                if (this.c.get() != 0) {
                    this.a.onNext(andSet);
                    BackpressureHelper.produced(this.c, 1L);
                } else {
                    cancel();
                    this.a.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this.d);
            this.e.cancel();
        }

        public void complete() {
            this.e.cancel();
            b();
        }

        abstract void d();

        public void error(Throwable th) {
            this.e.cancel();
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            SubscriptionHelper.cancel(this.d);
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            SubscriptionHelper.cancel(this.d);
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                this.e = subscription;
                this.a.onSubscribe(this);
                if (this.d.get() == null) {
                    this.b.subscribe(new SamplerSubscriber(this));
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.c, j);
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class SamplerSubscriber<T> implements FlowableSubscriber<Object> {
        final SamplePublisherSubscriber<T> a;

        SamplerSubscriber(SamplePublisherSubscriber<T> samplePublisherSubscriber) {
            this.a = samplePublisherSubscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.complete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.error(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            this.a.d();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            this.a.a(subscription);
        }
    }

    public FlowableSamplePublisher(Publisher<T> publisher, Publisher<?> publisher2, boolean z) {
        this.b = publisher;
        this.c = publisher2;
        this.d = z;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        Publisher<T> publisher;
        Subscriber<? super T> sampleMainNoLast;
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        if (this.d) {
            publisher = this.b;
            sampleMainNoLast = new SampleMainEmitLast<>(serializedSubscriber, this.c);
        } else {
            publisher = this.b;
            sampleMainNoLast = new SampleMainNoLast<>(serializedSubscriber, this.c);
        }
        publisher.subscribe(sampleMainNoLast);
    }
}
