package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableBuffer<T, C extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, C> {
    final int c;
    final int d;
    final Callable<C> e;

    /* loaded from: classes2.dex */
    static final class PublisherBufferExactSubscriber<T, C extends Collection<? super T>> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super C> a;
        final Callable<C> b;
        final int c;
        C d;
        Subscription e;
        boolean f;
        int g;

        PublisherBufferExactSubscriber(Subscriber<? super C> subscriber, int i, Callable<C> callable) {
            this.a = subscriber;
            this.c = i;
            this.b = callable;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.e.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f) {
                return;
            }
            this.f = true;
            C c = this.d;
            if (c != null && !c.isEmpty()) {
                this.a.onNext(c);
            }
            this.a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f) {
                RxJavaPlugins.onError(th);
            } else {
                this.f = true;
                this.a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f) {
                return;
            }
            C c = this.d;
            if (c == null) {
                try {
                    c = (C) ObjectHelper.requireNonNull(this.b.call(), "The bufferSupplier returned a null buffer");
                    this.d = c;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            c.add(t);
            int i = this.g + 1;
            if (i != this.c) {
                this.g = i;
                return;
            }
            this.g = 0;
            this.d = null;
            this.a.onNext(c);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                this.e = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                this.e.request(BackpressureHelper.multiplyCap(j, this.c));
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>> extends AtomicLong implements FlowableSubscriber<T>, Subscription, BooleanSupplier {
        private static final long serialVersionUID = -7370244972039324525L;
        final Subscriber<? super C> a;
        final Callable<C> b;
        final int c;
        final int d;
        Subscription g;
        boolean h;
        int i;
        volatile boolean j;
        long k;
        final AtomicBoolean f = new AtomicBoolean();
        final ArrayDeque<C> e = new ArrayDeque<>();

        PublisherBufferOverlappingSubscriber(Subscriber<? super C> subscriber, int i, int i2, Callable<C> callable) {
            this.a = subscriber;
            this.c = i;
            this.d = i2;
            this.b = callable;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.j = true;
            this.g.cancel();
        }

        @Override // io.reactivex.functions.BooleanSupplier
        public boolean getAsBoolean() {
            return this.j;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.h) {
                return;
            }
            this.h = true;
            long j = this.k;
            if (j != 0) {
                BackpressureHelper.produced(this, j);
            }
            QueueDrainHelper.postComplete(this.a, this.e, this, this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.h) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.h = true;
            this.e.clear();
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.h) {
                return;
            }
            ArrayDeque<C> arrayDeque = this.e;
            int i = this.i;
            int i2 = i + 1;
            if (i == 0) {
                try {
                    arrayDeque.offer((Collection) ObjectHelper.requireNonNull(this.b.call(), "The bufferSupplier returned a null buffer"));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            Collection collection = (Collection) arrayDeque.peek();
            if (collection != null && collection.size() + 1 == this.c) {
                arrayDeque.poll();
                collection.add(t);
                this.k++;
                this.a.onNext(collection);
            }
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                ((Collection) it.next()).add(t);
            }
            if (i2 == this.d) {
                i2 = 0;
            }
            this.i = i2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.g, subscription)) {
                this.g = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            long multiplyCap;
            if (!SubscriptionHelper.validate(j) || QueueDrainHelper.postCompleteRequest(j, this.a, this.e, this, this)) {
                return;
            }
            if (this.f.get() || !this.f.compareAndSet(false, true)) {
                multiplyCap = BackpressureHelper.multiplyCap(this.d, j);
            } else {
                multiplyCap = BackpressureHelper.addCap(this.c, BackpressureHelper.multiplyCap(this.d, j - 1));
            }
            this.g.request(multiplyCap);
        }
    }

    /* loaded from: classes2.dex */
    static final class PublisherBufferSkipSubscriber<T, C extends Collection<? super T>> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5616169793639412593L;
        final Subscriber<? super C> a;
        final Callable<C> b;
        final int c;
        final int d;
        C e;
        Subscription f;
        boolean g;
        int h;

        PublisherBufferSkipSubscriber(Subscriber<? super C> subscriber, int i, int i2, Callable<C> callable) {
            this.a = subscriber;
            this.c = i;
            this.d = i2;
            this.b = callable;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.g) {
                return;
            }
            this.g = true;
            C c = this.e;
            this.e = null;
            if (c != null) {
                this.a.onNext(c);
            }
            this.a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.g) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.g = true;
            this.e = null;
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.g) {
                return;
            }
            C c = this.e;
            int i = this.h;
            int i2 = i + 1;
            if (i == 0) {
                try {
                    c = (C) ObjectHelper.requireNonNull(this.b.call(), "The bufferSupplier returned a null buffer");
                    this.e = c;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            if (c != null) {
                c.add(t);
                if (c.size() == this.c) {
                    this.e = null;
                    this.a.onNext(c);
                }
            }
            if (i2 == this.d) {
                i2 = 0;
            }
            this.h = i2;
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
            if (SubscriptionHelper.validate(j)) {
                if (get() != 0 || !compareAndSet(0, 1)) {
                    this.f.request(BackpressureHelper.multiplyCap(this.d, j));
                    return;
                }
                this.f.request(BackpressureHelper.addCap(BackpressureHelper.multiplyCap(j, this.c), BackpressureHelper.multiplyCap(this.d - this.c, j - 1)));
            }
        }
    }

    public FlowableBuffer(Flowable<T> flowable, int i, int i2, Callable<C> callable) {
        super(flowable);
        this.c = i;
        this.d = i2;
        this.e = callable;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super C> subscriber) {
        int i = this.c;
        int i2 = this.d;
        if (i == i2) {
            this.b.subscribe((FlowableSubscriber) new PublisherBufferExactSubscriber(subscriber, i, this.e));
        } else {
            this.b.subscribe((FlowableSubscriber) (i2 > i ? new PublisherBufferSkipSubscriber<>(subscriber, i, i2, this.e) : new PublisherBufferOverlappingSubscriber<>(subscriber, i, i2, this.e)));
        }
    }
}
