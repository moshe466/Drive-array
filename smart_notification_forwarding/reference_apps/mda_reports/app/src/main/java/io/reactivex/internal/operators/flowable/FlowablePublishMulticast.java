package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowablePublishMulticast<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super Flowable<T>, ? extends Publisher<? extends R>> c;
    final int d;
    final boolean e;

    /* loaded from: classes2.dex */
    static final class MulticastProcessor<T> extends Flowable<T> implements FlowableSubscriber<T>, Disposable {
        static final MulticastSubscription[] m = new MulticastSubscription[0];
        static final MulticastSubscription[] n = new MulticastSubscription[0];
        final int d;
        final int e;
        final boolean f;
        volatile SimpleQueue<T> h;
        int i;
        volatile boolean j;
        Throwable k;
        int l;
        final AtomicInteger b = new AtomicInteger();
        final AtomicReference<Subscription> g = new AtomicReference<>();
        final AtomicReference<MulticastSubscription<T>[]> c = new AtomicReference<>(m);

        MulticastProcessor(int i, boolean z) {
            this.d = i;
            this.e = i - (i >> 2);
            this.f = z;
        }

        void a() {
            for (MulticastSubscription<T> multicastSubscription : this.c.getAndSet(n)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.a.onComplete();
                }
            }
        }

        void a(Throwable th) {
            for (MulticastSubscription<T> multicastSubscription : this.c.getAndSet(n)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.a.onError(th);
                }
            }
        }

        boolean a(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription<T>[] multicastSubscriptionArr;
            MulticastSubscription<T>[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = this.c.get();
                if (multicastSubscriptionArr == n) {
                    return false;
                }
                int length = multicastSubscriptionArr.length;
                multicastSubscriptionArr2 = new MulticastSubscription[length + 1];
                System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
                multicastSubscriptionArr2[length] = multicastSubscription;
            } while (!this.c.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2));
            return true;
        }

        void b() {
            AtomicReference<MulticastSubscription<T>[]> atomicReference;
            Throwable th;
            Throwable th2;
            if (this.b.getAndIncrement() != 0) {
                return;
            }
            SimpleQueue<T> simpleQueue = this.h;
            int i = this.l;
            int i2 = this.e;
            boolean z = this.i != 1;
            AtomicReference<MulticastSubscription<T>[]> atomicReference2 = this.c;
            MulticastSubscription<T>[] multicastSubscriptionArr = atomicReference2.get();
            int i3 = i;
            int i4 = 1;
            while (true) {
                int length = multicastSubscriptionArr.length;
                if (simpleQueue == null || length == 0) {
                    atomicReference = atomicReference2;
                } else {
                    int length2 = multicastSubscriptionArr.length;
                    long j = Long.MAX_VALUE;
                    int i5 = length;
                    long j2 = Long.MAX_VALUE;
                    int i6 = 0;
                    while (i6 < length2) {
                        MulticastSubscription<T> multicastSubscription = multicastSubscriptionArr[i6];
                        AtomicReference<MulticastSubscription<T>[]> atomicReference3 = atomicReference2;
                        long j3 = multicastSubscription.get() - multicastSubscription.c;
                        if (j3 == Long.MIN_VALUE) {
                            i5--;
                        } else if (j2 > j3) {
                            j2 = j3;
                        }
                        i6++;
                        atomicReference2 = atomicReference3;
                    }
                    atomicReference = atomicReference2;
                    long j4 = 0;
                    if (i5 == 0) {
                        j2 = 0;
                    }
                    while (j2 != j4) {
                        if (isDisposed()) {
                            simpleQueue.clear();
                            return;
                        }
                        boolean z2 = this.j;
                        if (z2 && !this.f && (th2 = this.k) != null) {
                            a(th2);
                            return;
                        }
                        try {
                            T poll = simpleQueue.poll();
                            boolean z3 = poll == null;
                            if (z2 && z3) {
                                Throwable th3 = this.k;
                                if (th3 != null) {
                                    a(th3);
                                    return;
                                } else {
                                    a();
                                    return;
                                }
                            }
                            if (z3) {
                                break;
                            }
                            int length3 = multicastSubscriptionArr.length;
                            int i7 = 0;
                            boolean z4 = false;
                            while (i7 < length3) {
                                MulticastSubscription<T> multicastSubscription2 = multicastSubscriptionArr[i7];
                                long j5 = multicastSubscription2.get();
                                if (j5 != Long.MIN_VALUE) {
                                    if (j5 != j) {
                                        multicastSubscription2.c++;
                                    }
                                    multicastSubscription2.a.onNext(poll);
                                } else {
                                    z4 = true;
                                }
                                i7++;
                                j = Long.MAX_VALUE;
                            }
                            j2--;
                            if (z && (i3 = i3 + 1) == i2) {
                                this.g.get().request(i2);
                                i3 = 0;
                            }
                            MulticastSubscription<T>[] multicastSubscriptionArr2 = atomicReference.get();
                            if (z4 || multicastSubscriptionArr2 != multicastSubscriptionArr) {
                                multicastSubscriptionArr = multicastSubscriptionArr2;
                                break;
                            } else {
                                j4 = 0;
                                j = Long.MAX_VALUE;
                            }
                        } catch (Throwable th4) {
                            Exceptions.throwIfFatal(th4);
                            SubscriptionHelper.cancel(this.g);
                            a(th4);
                            return;
                        }
                    }
                    if (j2 == j4) {
                        if (isDisposed()) {
                            simpleQueue.clear();
                            return;
                        }
                        boolean z5 = this.j;
                        if (z5 && !this.f && (th = this.k) != null) {
                            a(th);
                            return;
                        }
                        if (z5 && simpleQueue.isEmpty()) {
                            Throwable th5 = this.k;
                            if (th5 != null) {
                                a(th5);
                                return;
                            } else {
                                a();
                                return;
                            }
                        }
                    }
                }
                this.l = i3;
                i4 = this.b.addAndGet(-i4);
                if (i4 == 0) {
                    return;
                }
                if (simpleQueue == null) {
                    simpleQueue = this.h;
                }
                multicastSubscriptionArr = atomicReference.get();
                atomicReference2 = atomicReference;
            }
        }

        void b(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription<T>[] multicastSubscriptionArr;
            MulticastSubscription<T>[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = this.c.get();
                int length = multicastSubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (multicastSubscriptionArr[i2] == multicastSubscription) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    multicastSubscriptionArr2 = m;
                } else {
                    MulticastSubscription<T>[] multicastSubscriptionArr3 = new MulticastSubscription[length - 1];
                    System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr3, 0, i);
                    System.arraycopy(multicastSubscriptionArr, i + 1, multicastSubscriptionArr3, i, (length - i) - 1);
                    multicastSubscriptionArr2 = multicastSubscriptionArr3;
                }
            } while (!this.c.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2));
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SimpleQueue<T> simpleQueue;
            SubscriptionHelper.cancel(this.g);
            if (this.b.getAndIncrement() != 0 || (simpleQueue = this.h) == null) {
                return;
            }
            simpleQueue.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return SubscriptionHelper.isCancelled(this.g.get());
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.j) {
                return;
            }
            this.j = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.j) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.k = th;
            this.j = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.j) {
                return;
            }
            if (this.i != 0 || this.h.offer(t)) {
                b();
            } else {
                this.g.get().cancel();
                onError(new MissingBackpressureException());
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.g, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.i = requestFusion;
                        this.h = queueSubscription;
                        this.j = true;
                        b();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.i = requestFusion;
                        this.h = queueSubscription;
                        QueueDrainHelper.request(subscription, this.d);
                        return;
                    }
                }
                this.h = QueueDrainHelper.createQueue(this.d);
                QueueDrainHelper.request(subscription, this.d);
            }
        }

        @Override // io.reactivex.Flowable
        protected void subscribeActual(Subscriber<? super T> subscriber) {
            MulticastSubscription<T> multicastSubscription = new MulticastSubscription<>(subscriber, this);
            subscriber.onSubscribe(multicastSubscription);
            if (a(multicastSubscription)) {
                if (multicastSubscription.isCancelled()) {
                    b(multicastSubscription);
                    return;
                } else {
                    b();
                    return;
                }
            }
            Throwable th = this.k;
            if (th != null) {
                subscriber.onError(th);
            } else {
                subscriber.onComplete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 8664815189257569791L;
        final Subscriber<? super T> a;
        final MulticastProcessor<T> b;
        long c;

        MulticastSubscription(Subscriber<? super T> subscriber, MulticastProcessor<T> multicastProcessor) {
            this.a = subscriber;
            this.b = multicastProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.b.b(this);
                this.b.b();
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.addCancel(this, j);
                this.b.b();
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class OutputCanceller<R> implements FlowableSubscriber<R>, Subscription {
        final Subscriber<? super R> a;
        final MulticastProcessor<?> b;
        Subscription c;

        OutputCanceller(Subscriber<? super R> subscriber, MulticastProcessor<?> multicastProcessor) {
            this.a = subscriber;
            this.b = multicastProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.c.cancel();
            this.b.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.onComplete();
            this.b.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.onError(th);
            this.b.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(R r) {
            this.a.onNext(r);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.c, subscription)) {
                this.c = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.c.request(j);
        }
    }

    public FlowablePublishMulticast(Flowable<T> flowable, Function<? super Flowable<T>, ? extends Publisher<? extends R>> function, int i, boolean z) {
        super(flowable);
        this.c = function;
        this.d = i;
        this.e = z;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> subscriber) {
        MulticastProcessor multicastProcessor = new MulticastProcessor(this.d, this.e);
        try {
            ((Publisher) ObjectHelper.requireNonNull(this.c.apply(multicastProcessor), "selector returned a null Publisher")).subscribe(new OutputCanceller(subscriber, multicastProcessor));
            this.b.subscribe((FlowableSubscriber) multicastProcessor);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
