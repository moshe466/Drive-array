package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes3.dex */
public final class ParallelFromPublisher<T> extends ParallelFlowable<T> {
    final Publisher<? extends T> a;
    final int b;
    final int c;

    /* loaded from: classes3.dex */
    static final class ParallelDispatcher<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -4470634016609963609L;
        final Subscriber<? super T>[] a;
        final AtomicLongArray b;
        final long[] c;
        final int d;
        final int e;
        Subscription f;
        SimpleQueue<T> g;
        Throwable h;
        volatile boolean i;
        int j;
        volatile boolean k;
        final AtomicInteger l = new AtomicInteger();
        int m;
        int n;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public final class RailSubscription implements Subscription {
            final int a;
            final int b;

            RailSubscription(int i, int i2) {
                this.a = i;
                this.b = i2;
            }

            @Override // org.reactivestreams.Subscription
            public void cancel() {
                if (ParallelDispatcher.this.b.compareAndSet(this.a + this.b, 0L, 1L)) {
                    ParallelDispatcher parallelDispatcher = ParallelDispatcher.this;
                    int i = this.b;
                    parallelDispatcher.a(i + i);
                }
            }

            @Override // org.reactivestreams.Subscription
            public void request(long j) {
                long j2;
                if (SubscriptionHelper.validate(j)) {
                    AtomicLongArray atomicLongArray = ParallelDispatcher.this.b;
                    do {
                        j2 = atomicLongArray.get(this.a);
                        if (j2 == Long.MAX_VALUE) {
                            return;
                        }
                    } while (!atomicLongArray.compareAndSet(this.a, j2, BackpressureHelper.addCap(j2, j)));
                    if (ParallelDispatcher.this.l.get() == this.b) {
                        ParallelDispatcher.this.a();
                    }
                }
            }
        }

        ParallelDispatcher(Subscriber<? super T>[] subscriberArr, int i) {
            this.a = subscriberArr;
            this.d = i;
            this.e = i - (i >> 2);
            int length = subscriberArr.length;
            int i2 = length + length;
            this.b = new AtomicLongArray(i2 + 1);
            this.b.lazySet(i2, length);
            this.c = new long[length];
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.n == 1) {
                c();
            } else {
                b();
            }
        }

        void a(int i) {
            if (this.b.decrementAndGet(i) == 0) {
                this.k = true;
                this.f.cancel();
                if (getAndIncrement() == 0) {
                    this.g.clear();
                }
            }
        }

        void b() {
            Throwable th;
            SimpleQueue<T> simpleQueue = this.g;
            Subscriber<? super T>[] subscriberArr = this.a;
            AtomicLongArray atomicLongArray = this.b;
            long[] jArr = this.c;
            int length = jArr.length;
            int i = this.j;
            int i2 = this.m;
            int i3 = 1;
            while (true) {
                int i4 = 0;
                int i5 = i2;
                int i6 = 0;
                while (!this.k) {
                    boolean z = this.i;
                    if (z && (th = this.h) != null) {
                        simpleQueue.clear();
                        int length2 = subscriberArr.length;
                        while (i4 < length2) {
                            subscriberArr[i4].onError(th);
                            i4++;
                        }
                        return;
                    }
                    boolean isEmpty = simpleQueue.isEmpty();
                    if (z && isEmpty) {
                        int length3 = subscriberArr.length;
                        while (i4 < length3) {
                            subscriberArr[i4].onComplete();
                            i4++;
                        }
                        return;
                    }
                    if (!isEmpty) {
                        long j = atomicLongArray.get(i);
                        long j2 = jArr[i];
                        if (j == j2 || atomicLongArray.get(length + i) != 0) {
                            i6++;
                        } else {
                            try {
                                T poll = simpleQueue.poll();
                                if (poll != null) {
                                    subscriberArr[i].onNext(poll);
                                    jArr[i] = j2 + 1;
                                    int i7 = i5 + 1;
                                    if (i7 == this.e) {
                                        this.f.request(i7);
                                        i7 = 0;
                                    }
                                    i5 = i7;
                                    i6 = 0;
                                }
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                this.f.cancel();
                                int length4 = subscriberArr.length;
                                while (i4 < length4) {
                                    subscriberArr[i4].onError(th2);
                                    i4++;
                                }
                                return;
                            }
                        }
                        i++;
                        if (i == length) {
                            i = 0;
                        }
                        if (i6 == length) {
                        }
                    }
                    i2 = i5;
                    int i8 = get();
                    if (i8 == i3) {
                        this.j = i;
                        this.m = i2;
                        i3 = addAndGet(-i3);
                        if (i3 == 0) {
                            return;
                        }
                    } else {
                        i3 = i8;
                    }
                }
                simpleQueue.clear();
                return;
            }
        }

        void c() {
            SimpleQueue<T> simpleQueue = this.g;
            Subscriber<? super T>[] subscriberArr = this.a;
            AtomicLongArray atomicLongArray = this.b;
            long[] jArr = this.c;
            int length = jArr.length;
            int i = this.j;
            int i2 = 1;
            while (true) {
                int i3 = 0;
                int i4 = 0;
                while (!this.k) {
                    if (simpleQueue.isEmpty()) {
                        int length2 = subscriberArr.length;
                        while (i3 < length2) {
                            subscriberArr[i3].onComplete();
                            i3++;
                        }
                        return;
                    }
                    long j = atomicLongArray.get(i);
                    long j2 = jArr[i];
                    if (j == j2 || atomicLongArray.get(length + i) != 0) {
                        i4++;
                    } else {
                        try {
                            T poll = simpleQueue.poll();
                            if (poll == null) {
                                int length3 = subscriberArr.length;
                                while (i3 < length3) {
                                    subscriberArr[i3].onComplete();
                                    i3++;
                                }
                                return;
                            }
                            subscriberArr[i].onNext(poll);
                            jArr[i] = j2 + 1;
                            i4 = 0;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.f.cancel();
                            int length4 = subscriberArr.length;
                            while (i3 < length4) {
                                subscriberArr[i3].onError(th);
                                i3++;
                            }
                            return;
                        }
                    }
                    i++;
                    if (i == length) {
                        i = 0;
                    }
                    if (i4 == length) {
                        int i5 = get();
                        if (i5 == i2) {
                            this.j = i;
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else {
                            i2 = i5;
                        }
                    }
                }
                simpleQueue.clear();
                return;
            }
        }

        void d() {
            Subscriber<? super T>[] subscriberArr = this.a;
            int length = subscriberArr.length;
            int i = 0;
            while (i < length && !this.k) {
                int i2 = i + 1;
                this.l.lazySet(i2);
                subscriberArr[i].onSubscribe(new RailSubscription(i, length));
                i = i2;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.i = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.h = th;
            this.i = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.n != 0 || this.g.offer(t)) {
                a();
            } else {
                this.f.cancel();
                onError(new MissingBackpressureException("Queue is full?"));
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.n = requestFusion;
                        this.g = queueSubscription;
                        this.i = true;
                        d();
                        a();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.n = requestFusion;
                        this.g = queueSubscription;
                        d();
                        subscription.request(this.d);
                        return;
                    }
                }
                this.g = new SpscArrayQueue(this.d);
                d();
                subscription.request(this.d);
            }
        }
    }

    public ParallelFromPublisher(Publisher<? extends T> publisher, int i, int i2) {
        this.a = publisher;
        this.b = i;
        this.c = i2;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.b;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (a(subscriberArr)) {
            this.a.subscribe(new ParallelDispatcher(subscriberArr, this.c));
        }
    }
}
