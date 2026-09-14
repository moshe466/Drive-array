package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableConcatMapEager<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super T, ? extends Publisher<? extends R>> c;
    final int d;
    final int e;
    final ErrorMode f;

    /* loaded from: classes2.dex */
    static final class ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, InnerQueuedSubscriberSupport<R> {
        private static final long serialVersionUID = -4255299542215038287L;
        final Subscriber<? super R> a;
        final Function<? super T, ? extends Publisher<? extends R>> b;
        final int c;
        final int d;
        final ErrorMode e;
        final AtomicThrowable f = new AtomicThrowable();
        final AtomicLong g = new AtomicLong();
        final SpscLinkedArrayQueue<InnerQueuedSubscriber<R>> h;
        Subscription i;
        volatile boolean j;
        volatile boolean k;
        volatile InnerQueuedSubscriber<R> l;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ConcatMapEagerDelayErrorSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, ErrorMode errorMode) {
            this.a = subscriber;
            this.b = function;
            this.c = i;
            this.d = i2;
            this.e = errorMode;
            this.h = new SpscLinkedArrayQueue<>(Math.min(i2, i));
        }

        void a() {
            while (true) {
                InnerQueuedSubscriber<R> poll = this.h.poll();
                if (poll == null) {
                    return;
                } else {
                    poll.cancel();
                }
            }
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            do {
                a();
            } while (decrementAndGet() != 0);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.j) {
                return;
            }
            this.j = true;
            this.i.cancel();
            b();
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void drain() {
            InnerQueuedSubscriber<R> innerQueuedSubscriber;
            int i;
            long j;
            boolean z;
            SimpleQueue<R> queue;
            if (getAndIncrement() != 0) {
                return;
            }
            InnerQueuedSubscriber<R> innerQueuedSubscriber2 = this.l;
            Subscriber<? super R> subscriber = this.a;
            ErrorMode errorMode = this.e;
            int i2 = 1;
            while (true) {
                long j2 = this.g.get();
                if (innerQueuedSubscriber2 != null) {
                    innerQueuedSubscriber = innerQueuedSubscriber2;
                } else {
                    if (errorMode != ErrorMode.END && this.f.get() != null) {
                        a();
                        subscriber.onError(this.f.terminate());
                        return;
                    }
                    boolean z2 = this.k;
                    innerQueuedSubscriber = this.h.poll();
                    if (z2 && innerQueuedSubscriber == null) {
                        Throwable terminate = this.f.terminate();
                        if (terminate != null) {
                            subscriber.onError(terminate);
                            return;
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    }
                    if (innerQueuedSubscriber != null) {
                        this.l = innerQueuedSubscriber;
                    }
                }
                if (innerQueuedSubscriber == null || (queue = innerQueuedSubscriber.queue()) == null) {
                    i = i2;
                    innerQueuedSubscriber2 = innerQueuedSubscriber;
                    j = 0;
                    z = false;
                } else {
                    i = i2;
                    j = 0;
                    while (j != j2) {
                        if (this.j) {
                            a();
                            return;
                        }
                        if (errorMode == ErrorMode.IMMEDIATE && this.f.get() != null) {
                            this.l = null;
                            innerQueuedSubscriber.cancel();
                            a();
                            subscriber.onError(this.f.terminate());
                            return;
                        }
                        boolean isDone = innerQueuedSubscriber.isDone();
                        try {
                            R poll = queue.poll();
                            boolean z3 = poll == null;
                            if (isDone && z3) {
                                this.l = null;
                                this.i.request(1L);
                                innerQueuedSubscriber = null;
                                z = true;
                                break;
                            }
                            if (z3) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j++;
                            innerQueuedSubscriber.requestOne();
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.l = null;
                            innerQueuedSubscriber.cancel();
                            a();
                            subscriber.onError(th);
                            return;
                        }
                    }
                    z = false;
                    if (j == j2) {
                        if (this.j) {
                            a();
                            return;
                        }
                        if (errorMode == ErrorMode.IMMEDIATE && this.f.get() != null) {
                            this.l = null;
                            innerQueuedSubscriber.cancel();
                            a();
                            subscriber.onError(this.f.terminate());
                            return;
                        }
                        boolean isDone2 = innerQueuedSubscriber.isDone();
                        boolean isEmpty = queue.isEmpty();
                        if (isDone2 && isEmpty) {
                            this.l = null;
                            this.i.request(1L);
                            innerQueuedSubscriber2 = null;
                            z = true;
                        }
                    }
                    innerQueuedSubscriber2 = innerQueuedSubscriber;
                }
                if (j != 0 && j2 != Long.MAX_VALUE) {
                    this.g.addAndGet(-j);
                }
                if (z) {
                    i2 = i;
                } else {
                    i2 = addAndGet(-i);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerComplete(InnerQueuedSubscriber<R> innerQueuedSubscriber) {
            innerQueuedSubscriber.setDone();
            drain();
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerError(InnerQueuedSubscriber<R> innerQueuedSubscriber, Throwable th) {
            if (!this.f.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            innerQueuedSubscriber.setDone();
            if (this.e != ErrorMode.END) {
                this.i.cancel();
            }
            drain();
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerNext(InnerQueuedSubscriber<R> innerQueuedSubscriber, R r) {
            if (innerQueuedSubscriber.queue().offer(r)) {
                drain();
            } else {
                innerQueuedSubscriber.cancel();
                innerError(innerQueuedSubscriber, new MissingBackpressureException());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.k = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.f.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.k = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            try {
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.b.apply(t), "The mapper returned a null Publisher");
                InnerQueuedSubscriber<R> innerQueuedSubscriber = new InnerQueuedSubscriber<>(this, this.d);
                if (this.j) {
                    return;
                }
                this.h.offer(innerQueuedSubscriber);
                publisher.subscribe(innerQueuedSubscriber);
                if (this.j) {
                    innerQueuedSubscriber.cancel();
                    b();
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.i.cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.i, subscription)) {
                this.i = subscription;
                this.a.onSubscribe(this);
                int i = this.c;
                subscription.request(i == Integer.MAX_VALUE ? Long.MAX_VALUE : i);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.g, j);
                drain();
            }
        }
    }

    public FlowableConcatMapEager(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, ErrorMode errorMode) {
        super(flowable);
        this.c = function;
        this.d = i;
        this.e = i2;
        this.f = errorMode;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe((FlowableSubscriber) new ConcatMapEagerDelayErrorSubscriber(subscriber, this.c, this.d, this.e, this.f));
    }
}
