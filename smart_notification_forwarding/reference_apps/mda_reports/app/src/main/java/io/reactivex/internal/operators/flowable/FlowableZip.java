package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableZip<T, R> extends Flowable<R> {
    final Publisher<? extends T>[] b;
    final Iterable<? extends Publisher<? extends T>> c;
    final Function<? super Object[], ? extends R> d;
    final int e;
    final boolean f;

    /* loaded from: classes2.dex */
    static final class ZipCoordinator<T, R> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = -2434867452883857743L;
        final Subscriber<? super R> a;
        final ZipSubscriber<T, R>[] b;
        final Function<? super Object[], ? extends R> c;
        final AtomicLong d;
        final AtomicThrowable e;
        final boolean f;
        volatile boolean g;
        final Object[] h;

        ZipCoordinator(Subscriber<? super R> subscriber, Function<? super Object[], ? extends R> function, int i, int i2, boolean z) {
            this.a = subscriber;
            this.c = function;
            this.f = z;
            ZipSubscriber<T, R>[] zipSubscriberArr = new ZipSubscriber[i];
            for (int i3 = 0; i3 < i; i3++) {
                zipSubscriberArr[i3] = new ZipSubscriber<>(this, i2);
            }
            this.h = new Object[i];
            this.b = zipSubscriberArr;
            this.d = new AtomicLong();
            this.e = new AtomicThrowable();
        }

        void a() {
            for (ZipSubscriber<T, R> zipSubscriber : this.b) {
                zipSubscriber.cancel();
            }
        }

        void a(ZipSubscriber<T, R> zipSubscriber, Throwable th) {
            if (!this.e.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                zipSubscriber.f = true;
                b();
            }
        }

        void a(Publisher<? extends T>[] publisherArr, int i) {
            ZipSubscriber<T, R>[] zipSubscriberArr = this.b;
            for (int i2 = 0; i2 < i && !this.g; i2++) {
                if (!this.f && this.e.get() != null) {
                    return;
                }
                publisherArr[i2].subscribe(zipSubscriberArr[i2]);
            }
        }

        void b() {
            boolean z;
            T poll;
            boolean z2;
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.a;
            ZipSubscriber<T, R>[] zipSubscriberArr = this.b;
            int length = zipSubscriberArr.length;
            Object[] objArr = this.h;
            int i = 1;
            loop0: do {
                long j = this.d.get();
                long j2 = 0;
                while (j != j2) {
                    if (this.g) {
                        return;
                    }
                    if (!this.f && this.e.get() != null) {
                        break loop0;
                    }
                    boolean z3 = false;
                    for (int i2 = 0; i2 < length; i2++) {
                        ZipSubscriber<T, R> zipSubscriber = zipSubscriberArr[i2];
                        if (objArr[i2] == null) {
                            try {
                                z = zipSubscriber.f;
                                SimpleQueue<T> simpleQueue = zipSubscriber.d;
                                poll = simpleQueue != null ? simpleQueue.poll() : null;
                                z2 = poll == null;
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.e.addThrowable(th);
                                if (!this.f) {
                                    break loop0;
                                }
                            }
                            if (z && z2) {
                                a();
                                if (this.e.get() != null) {
                                    subscriber.onError(this.e.terminate());
                                    return;
                                } else {
                                    subscriber.onComplete();
                                    return;
                                }
                            }
                            if (!z2) {
                                objArr[i2] = poll;
                            }
                            z3 = true;
                        }
                    }
                    if (z3) {
                        break;
                    }
                    try {
                        subscriber.onNext((Object) ObjectHelper.requireNonNull(this.c.apply(objArr.clone()), "The zipper returned a null value"));
                        j2++;
                        Arrays.fill(objArr, (Object) null);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        a();
                        this.e.addThrowable(th2);
                    }
                }
                if (j == j2) {
                    if (this.g) {
                        return;
                    }
                    if (this.f || this.e.get() == null) {
                        for (int i3 = 0; i3 < length; i3++) {
                            ZipSubscriber<T, R> zipSubscriber2 = zipSubscriberArr[i3];
                            if (objArr[i3] == null) {
                                try {
                                    boolean z4 = zipSubscriber2.f;
                                    SimpleQueue<T> simpleQueue2 = zipSubscriber2.d;
                                    T poll2 = simpleQueue2 != null ? simpleQueue2.poll() : null;
                                    boolean z5 = poll2 == null;
                                    if (z4 && z5) {
                                        a();
                                        if (this.e.get() != null) {
                                            subscriber.onError(this.e.terminate());
                                            return;
                                        } else {
                                            subscriber.onComplete();
                                            return;
                                        }
                                    }
                                    if (!z5) {
                                        objArr[i3] = poll2;
                                    }
                                } catch (Throwable th3) {
                                    Exceptions.throwIfFatal(th3);
                                    this.e.addThrowable(th3);
                                    if (!this.f) {
                                    }
                                }
                            }
                        }
                    }
                    a();
                    subscriber.onError(this.e.terminate());
                    return;
                }
                if (j2 != 0) {
                    for (ZipSubscriber<T, R> zipSubscriber3 : zipSubscriberArr) {
                        zipSubscriber3.request(j2);
                    }
                    if (j != Long.MAX_VALUE) {
                        this.d.addAndGet(-j2);
                    }
                }
                i = addAndGet(-i);
            } while (i != 0);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.g) {
                return;
            }
            this.g = true;
            a();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.d, j);
                b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class ZipSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4627193790118206028L;
        final ZipCoordinator<T, R> a;
        final int b;
        final int c;
        SimpleQueue<T> d;
        long e;
        volatile boolean f;
        int g;

        ZipSubscriber(ZipCoordinator<T, R> zipCoordinator, int i) {
            this.a = zipCoordinator;
            this.b = i;
            this.c = i - (i >> 2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f = true;
            this.a.b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.a(this, th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.g != 2) {
                this.d.offer(t);
            }
            this.a.b();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.g = requestFusion;
                        this.d = queueSubscription;
                        this.f = true;
                        this.a.b();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.g = requestFusion;
                        this.d = queueSubscription;
                        subscription.request(this.b);
                        return;
                    }
                }
                this.d = new SpscArrayQueue(this.b);
                subscription.request(this.b);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (this.g != 1) {
                long j2 = this.e + j;
                if (j2 < this.c) {
                    this.e = j2;
                } else {
                    this.e = 0L;
                    get().request(j2);
                }
            }
        }
    }

    public FlowableZip(Publisher<? extends T>[] publisherArr, Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.b = publisherArr;
        this.c = iterable;
        this.d = function;
        this.e = i;
        this.f = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        int length;
        Publisher<? extends T>[] publisherArr = this.b;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            length = 0;
            for (Publisher<? extends T> publisher : this.c) {
                if (length == publisherArr.length) {
                    Publisher<? extends T>[] publisherArr2 = new Publisher[(length >> 2) + length];
                    System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                    publisherArr = publisherArr2;
                }
                publisherArr[length] = publisher;
                length++;
            }
        } else {
            length = publisherArr.length;
        }
        if (length == 0) {
            EmptySubscription.complete(subscriber);
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(subscriber, this.d, length, this.e, this.f);
        subscriber.onSubscribe(zipCoordinator);
        zipCoordinator.a(publisherArr, length);
    }
}
