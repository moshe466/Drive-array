package io.reactivex.processors;

import io.reactivex.Flowable;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@SchedulerSupport(SchedulerSupport.NONE)
@BackpressureSupport(BackpressureKind.FULL)
@Experimental
/* loaded from: classes.dex */
public final class MulticastProcessor<T> extends FlowableProcessor<T> {
    static final MulticastSubscription[] n = new MulticastSubscription[0];
    static final MulticastSubscription[] o = new MulticastSubscription[0];
    final AtomicInteger b;
    final AtomicReference<Subscription> c;
    final AtomicReference<MulticastSubscription<T>[]> d;
    final AtomicBoolean e;
    final int f;
    final int g;
    final boolean h;
    volatile SimpleQueue<T> i;
    volatile boolean j;
    volatile Throwable k;
    int l;
    int m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = -363282618957264509L;
        final Subscriber<? super T> a;
        final MulticastProcessor<T> b;
        long c;

        MulticastSubscription(Subscriber<? super T> subscriber, MulticastProcessor<T> multicastProcessor) {
            this.a = subscriber;
            this.b = multicastProcessor;
        }

        void a() {
            if (get() != Long.MIN_VALUE) {
                this.a.onComplete();
            }
        }

        void a(T t) {
            if (get() != Long.MIN_VALUE) {
                this.c++;
                this.a.onNext(t);
            }
        }

        void a(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.b.b(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            long j2;
            long j3;
            if (!SubscriptionHelper.validate(j)) {
                return;
            }
            do {
                j2 = get();
                if (j2 == Long.MIN_VALUE) {
                    return;
                }
                if (j2 == Long.MAX_VALUE) {
                    return;
                } else {
                    j3 = j2 + j;
                }
            } while (!compareAndSet(j2, j3 >= 0 ? j3 : Long.MAX_VALUE));
            this.b.a();
        }
    }

    MulticastProcessor(int i, boolean z) {
        ObjectHelper.verifyPositive(i, "bufferSize");
        this.f = i;
        this.g = i - (i >> 2);
        this.b = new AtomicInteger();
        this.d = new AtomicReference<>(n);
        this.c = new AtomicReference<>();
        this.h = z;
        this.e = new AtomicBoolean();
    }

    @CheckReturnValue
    @NonNull
    public static <T> MulticastProcessor<T> create() {
        return new MulticastProcessor<>(Flowable.bufferSize(), false);
    }

    @CheckReturnValue
    @NonNull
    public static <T> MulticastProcessor<T> create(int i) {
        return new MulticastProcessor<>(i, false);
    }

    @CheckReturnValue
    @NonNull
    public static <T> MulticastProcessor<T> create(int i, boolean z) {
        return new MulticastProcessor<>(i, z);
    }

    @CheckReturnValue
    @NonNull
    public static <T> MulticastProcessor<T> create(boolean z) {
        return new MulticastProcessor<>(Flowable.bufferSize(), z);
    }

    void a() {
        T t;
        boolean z;
        if (this.b.getAndIncrement() != 0) {
            return;
        }
        AtomicReference<MulticastSubscription<T>[]> atomicReference = this.d;
        int i = this.l;
        int i2 = this.g;
        int i3 = this.m;
        int i4 = 1;
        while (true) {
            SimpleQueue<T> simpleQueue = this.i;
            if (simpleQueue != null) {
                MulticastSubscription<T>[] multicastSubscriptionArr = atomicReference.get();
                if (multicastSubscriptionArr.length != 0) {
                    int length = multicastSubscriptionArr.length;
                    long j = -1;
                    long j2 = -1;
                    int i5 = 0;
                    while (i5 < length) {
                        MulticastSubscription<T> multicastSubscription = multicastSubscriptionArr[i5];
                        long j3 = multicastSubscription.get();
                        if (j3 >= 0) {
                            j2 = j2 == j ? j3 - multicastSubscription.c : Math.min(j2, j3 - multicastSubscription.c);
                        }
                        i5++;
                        j = -1;
                    }
                    int i6 = i;
                    while (j2 > 0) {
                        MulticastSubscription<T>[] multicastSubscriptionArr2 = atomicReference.get();
                        if (multicastSubscriptionArr2 == o) {
                            simpleQueue.clear();
                            return;
                        }
                        if (multicastSubscriptionArr != multicastSubscriptionArr2) {
                            break;
                        }
                        try {
                            z = this.j;
                            t = simpleQueue.poll();
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            SubscriptionHelper.cancel(this.c);
                            t = null;
                            this.k = th;
                            this.j = true;
                            z = true;
                        }
                        boolean z2 = t == null;
                        if (z && z2) {
                            Throwable th2 = this.k;
                            if (th2 != null) {
                                for (MulticastSubscription<T> multicastSubscription2 : atomicReference.getAndSet(o)) {
                                    multicastSubscription2.a(th2);
                                }
                                return;
                            }
                            for (MulticastSubscription<T> multicastSubscription3 : atomicReference.getAndSet(o)) {
                                multicastSubscription3.a();
                            }
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        for (MulticastSubscription<T> multicastSubscription4 : multicastSubscriptionArr) {
                            multicastSubscription4.a((MulticastSubscription<T>) t);
                        }
                        j2--;
                        if (i3 != 1) {
                            int i7 = i6 + 1;
                            if (i7 == i2) {
                                this.c.get().request(i2);
                                i6 = 0;
                            } else {
                                i6 = i7;
                            }
                        }
                    }
                    if (j2 == 0) {
                        MulticastSubscription<T>[] multicastSubscriptionArr3 = atomicReference.get();
                        if (multicastSubscriptionArr3 == o) {
                            simpleQueue.clear();
                            return;
                        }
                        if (multicastSubscriptionArr != multicastSubscriptionArr3) {
                            i = i6;
                        } else if (this.j && simpleQueue.isEmpty()) {
                            Throwable th3 = this.k;
                            if (th3 != null) {
                                for (MulticastSubscription<T> multicastSubscription5 : atomicReference.getAndSet(o)) {
                                    multicastSubscription5.a(th3);
                                }
                                return;
                            }
                            for (MulticastSubscription<T> multicastSubscription6 : atomicReference.getAndSet(o)) {
                                multicastSubscription6.a();
                            }
                            return;
                        }
                    }
                    i = i6;
                }
            }
            i4 = this.b.addAndGet(-i4);
            if (i4 == 0) {
                return;
            }
        }
    }

    boolean a(MulticastSubscription<T> multicastSubscription) {
        MulticastSubscription<T>[] multicastSubscriptionArr;
        MulticastSubscription<T>[] multicastSubscriptionArr2;
        do {
            multicastSubscriptionArr = this.d.get();
            if (multicastSubscriptionArr == o) {
                return false;
            }
            int length = multicastSubscriptionArr.length;
            multicastSubscriptionArr2 = new MulticastSubscription[length + 1];
            System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
            multicastSubscriptionArr2[length] = multicastSubscription;
        } while (!this.d.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2));
        return true;
    }

    void b(MulticastSubscription<T> multicastSubscription) {
        while (true) {
            MulticastSubscription<T>[] multicastSubscriptionArr = this.d.get();
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
            if (length != 1) {
                MulticastSubscription<T>[] multicastSubscriptionArr2 = new MulticastSubscription[length - 1];
                System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, i);
                System.arraycopy(multicastSubscriptionArr, i + 1, multicastSubscriptionArr2, i, (length - i) - 1);
                if (this.d.compareAndSet(multicastSubscriptionArr, multicastSubscriptionArr2)) {
                    return;
                }
            } else if (this.h) {
                if (this.d.compareAndSet(multicastSubscriptionArr, o)) {
                    SubscriptionHelper.cancel(this.c);
                    this.e.set(true);
                    return;
                }
            } else if (this.d.compareAndSet(multicastSubscriptionArr, n)) {
                return;
            }
        }
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public Throwable getThrowable() {
        if (this.e.get()) {
            return this.k;
        }
        return null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        return this.e.get() && this.k == null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        return this.d.get().length != 0;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        return this.e.get() && this.k != null;
    }

    public boolean offer(T t) {
        if (this.e.get()) {
            return false;
        }
        ObjectHelper.requireNonNull(t, "offer called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.m != 0 || !this.i.offer(t)) {
            return false;
        }
        a();
        return true;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.e.compareAndSet(false, true)) {
            this.j = true;
            a();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.e.compareAndSet(false, true)) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.k = th;
        this.j = true;
        a();
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.e.get()) {
            return;
        }
        if (this.m == 0) {
            ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (!this.i.offer(t)) {
                SubscriptionHelper.cancel(this.c);
                onError(new MissingBackpressureException());
                return;
            }
        }
        a();
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.c, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.m = requestFusion;
                    this.i = queueSubscription;
                    this.j = true;
                    a();
                    return;
                }
                if (requestFusion == 2) {
                    this.m = requestFusion;
                    this.i = queueSubscription;
                    subscription.request(this.f);
                    return;
                }
            }
            this.i = new SpscArrayQueue(this.f);
            subscription.request(this.f);
        }
    }

    public void start() {
        if (SubscriptionHelper.setOnce(this.c, EmptySubscription.INSTANCE)) {
            this.i = new SpscArrayQueue(this.f);
        }
    }

    public void startUnbounded() {
        if (SubscriptionHelper.setOnce(this.c, EmptySubscription.INSTANCE)) {
            this.i = new SpscLinkedArrayQueue(this.f);
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        Throwable th;
        MulticastSubscription<T> multicastSubscription = new MulticastSubscription<>(subscriber, this);
        subscriber.onSubscribe(multicastSubscription);
        if (a(multicastSubscription)) {
            if (multicastSubscription.get() == Long.MIN_VALUE) {
                b(multicastSubscription);
                return;
            } else {
                a();
                return;
            }
        }
        if ((this.e.get() || !this.h) && (th = this.k) != null) {
            subscriber.onError(th);
        } else {
            subscriber.onComplete();
        }
    }
}
