package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableSequenceEqual<T> extends Flowable<Boolean> {
    final Publisher<? extends T> b;
    final Publisher<? extends T> c;
    final BiPredicate<? super T, ? super T> d;
    final int e;

    /* loaded from: classes2.dex */
    static final class EqualCoordinator<T> extends DeferredScalarSubscription<Boolean> implements EqualCoordinatorHelper {
        private static final long serialVersionUID = -6178010334400373240L;
        final BiPredicate<? super T, ? super T> c;
        final EqualSubscriber<T> d;
        final EqualSubscriber<T> e;
        final AtomicThrowable f;
        final AtomicInteger g;
        T h;
        T i;

        EqualCoordinator(Subscriber<? super Boolean> subscriber, int i, BiPredicate<? super T, ? super T> biPredicate) {
            super(subscriber);
            this.c = biPredicate;
            this.g = new AtomicInteger();
            this.d = new EqualSubscriber<>(this, i);
            this.e = new EqualSubscriber<>(this, i);
            this.f = new AtomicThrowable();
        }

        void a() {
            this.d.cancel();
            this.d.a();
            this.e.cancel();
            this.e.a();
        }

        void a(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
            publisher.subscribe(this.d);
            publisher2.subscribe(this.e);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.d.cancel();
            this.e.cancel();
            if (this.g.getAndIncrement() == 0) {
                this.d.a();
                this.e.a();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinatorHelper
        public void drain() {
            if (this.g.getAndIncrement() != 0) {
                return;
            }
            int i = 1;
            do {
                SimpleQueue<T> simpleQueue = this.d.e;
                SimpleQueue<T> simpleQueue2 = this.e.e;
                if (simpleQueue != null && simpleQueue2 != null) {
                    while (!isCancelled()) {
                        if (this.f.get() != null) {
                            a();
                            this.a.onError(this.f.terminate());
                            return;
                        }
                        boolean z = this.d.f;
                        T t = this.h;
                        if (t == null) {
                            try {
                                t = simpleQueue.poll();
                                this.h = t;
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                a();
                                this.f.addThrowable(th);
                                this.a.onError(this.f.terminate());
                                return;
                            }
                        }
                        boolean z2 = t == null;
                        boolean z3 = this.e.f;
                        T t2 = this.i;
                        if (t2 == null) {
                            try {
                                t2 = simpleQueue2.poll();
                                this.i = t2;
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                a();
                                this.f.addThrowable(th2);
                                this.a.onError(this.f.terminate());
                                return;
                            }
                        }
                        boolean z4 = t2 == null;
                        if (z && z3 && z2 && z4) {
                            complete(true);
                            return;
                        }
                        if (z && z3 && z2 != z4) {
                            a();
                            complete(false);
                            return;
                        }
                        if (!z2 && !z4) {
                            try {
                                if (!this.c.test(t, t2)) {
                                    a();
                                    complete(false);
                                    return;
                                } else {
                                    this.h = null;
                                    this.i = null;
                                    this.d.request();
                                    this.e.request();
                                }
                            } catch (Throwable th3) {
                                Exceptions.throwIfFatal(th3);
                                a();
                                this.f.addThrowable(th3);
                                this.a.onError(this.f.terminate());
                                return;
                            }
                        }
                    }
                    this.d.a();
                    this.e.a();
                    return;
                }
                if (isCancelled()) {
                    this.d.a();
                    this.e.a();
                    return;
                } else if (this.f.get() != null) {
                    a();
                    this.a.onError(this.f.terminate());
                    return;
                }
                i = this.g.addAndGet(-i);
            } while (i != 0);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinatorHelper
        public void innerError(Throwable th) {
            if (this.f.addThrowable(th)) {
                drain();
            } else {
                RxJavaPlugins.onError(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface EqualCoordinatorHelper {
        void drain();

        void innerError(Throwable th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class EqualSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 4804128302091633067L;
        final EqualCoordinatorHelper a;
        final int b;
        final int c;
        long d;
        volatile SimpleQueue<T> e;
        volatile boolean f;
        int g;

        /* JADX INFO: Access modifiers changed from: package-private */
        public EqualSubscriber(EqualCoordinatorHelper equalCoordinatorHelper, int i) {
            this.a = equalCoordinatorHelper;
            this.c = i - (i >> 2);
            this.b = i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            SimpleQueue<T> simpleQueue = this.e;
            if (simpleQueue != null) {
                simpleQueue.clear();
            }
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f = true;
            this.a.drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.innerError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.g != 0 || this.e.offer(t)) {
                this.a.drain();
            } else {
                onError(new MissingBackpressureException());
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.g = requestFusion;
                        this.e = queueSubscription;
                        this.f = true;
                        this.a.drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.g = requestFusion;
                        this.e = queueSubscription;
                        subscription.request(this.b);
                        return;
                    }
                }
                this.e = new SpscArrayQueue(this.b);
                subscription.request(this.b);
            }
        }

        public void request() {
            if (this.g != 1) {
                long j = this.d + 1;
                if (j < this.c) {
                    this.d = j;
                } else {
                    this.d = 0L;
                    get().request(j);
                }
            }
        }
    }

    public FlowableSequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, BiPredicate<? super T, ? super T> biPredicate, int i) {
        this.b = publisher;
        this.c = publisher2;
        this.d = biPredicate;
        this.e = i;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Boolean> subscriber) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(subscriber, this.e, this.d);
        subscriber.onSubscribe(equalCoordinator);
        equalCoordinator.a(this.b, this.c);
    }
}
