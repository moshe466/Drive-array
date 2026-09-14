package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableMap;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableCombineLatest<T, R> extends Flowable<R> {

    @Nullable
    final Publisher<? extends T>[] b;

    @Nullable
    final Iterable<? extends Publisher<? extends T>> c;
    final Function<? super Object[], ? extends R> d;
    final int e;
    final boolean f;

    /* loaded from: classes2.dex */
    static final class CombineLatestCoordinator<T, R> extends BasicIntQueueSubscription<R> {
        private static final long serialVersionUID = -5082275438355852221L;
        final Subscriber<? super R> a;
        final Function<? super Object[], ? extends R> b;
        final CombineLatestInnerSubscriber<T>[] c;
        final SpscLinkedArrayQueue<Object> d;
        final Object[] e;
        final boolean f;
        boolean g;
        int h;
        int i;
        volatile boolean j;
        final AtomicLong k;
        volatile boolean l;
        final AtomicReference<Throwable> m;

        CombineLatestCoordinator(Subscriber<? super R> subscriber, Function<? super Object[], ? extends R> function, int i, int i2, boolean z) {
            this.a = subscriber;
            this.b = function;
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = new CombineLatestInnerSubscriber[i];
            for (int i3 = 0; i3 < i; i3++) {
                combineLatestInnerSubscriberArr[i3] = new CombineLatestInnerSubscriber<>(this, i3, i2);
            }
            this.c = combineLatestInnerSubscriberArr;
            this.e = new Object[i];
            this.d = new SpscLinkedArrayQueue<>(i2);
            this.k = new AtomicLong();
            this.m = new AtomicReference<>();
            this.f = z;
        }

        void a() {
            for (CombineLatestInnerSubscriber<T> combineLatestInnerSubscriber : this.c) {
                combineLatestInnerSubscriber.cancel();
            }
        }

        void a(int i) {
            int i2;
            synchronized (this) {
                Object[] objArr = this.e;
                if (objArr[i] != null && (i2 = this.i + 1) != objArr.length) {
                    this.i = i2;
                } else {
                    this.l = true;
                    drain();
                }
            }
        }

        void a(int i, T t) {
            boolean z;
            synchronized (this) {
                Object[] objArr = this.e;
                int i2 = this.h;
                if (objArr[i] == null) {
                    i2++;
                    this.h = i2;
                }
                objArr[i] = t;
                if (objArr.length == i2) {
                    this.d.offer(this.c[i], objArr.clone());
                    z = false;
                } else {
                    z = true;
                }
            }
            if (z) {
                this.c[i].requestOne();
            } else {
                drain();
            }
        }

        void a(int i, Throwable th) {
            if (!ExceptionHelper.addThrowable(this.m, th)) {
                RxJavaPlugins.onError(th);
            } else {
                if (this.f) {
                    a(i);
                    return;
                }
                a();
                this.l = true;
                drain();
            }
        }

        void a(Publisher<? extends T>[] publisherArr, int i) {
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = this.c;
            for (int i2 = 0; i2 < i && !this.l && !this.j; i2++) {
                publisherArr[i2].subscribe(combineLatestInnerSubscriberArr[i2]);
            }
        }

        boolean a(boolean z, boolean z2, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            if (this.j) {
                a();
                spscLinkedArrayQueue.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.f) {
                if (!z2) {
                    return false;
                }
                a();
                Throwable terminate = ExceptionHelper.terminate(this.m);
                if (terminate == null || terminate == ExceptionHelper.TERMINATED) {
                    subscriber.onComplete();
                } else {
                    subscriber.onError(terminate);
                }
                return true;
            }
            Throwable terminate2 = ExceptionHelper.terminate(this.m);
            if (terminate2 != null && terminate2 != ExceptionHelper.TERMINATED) {
                a();
                spscLinkedArrayQueue.clear();
                subscriber.onError(terminate2);
                return true;
            }
            if (!z2) {
                return false;
            }
            a();
            subscriber.onComplete();
            return true;
        }

        void b() {
            Subscriber<? super R> subscriber = this.a;
            SpscLinkedArrayQueue<?> spscLinkedArrayQueue = this.d;
            int i = 1;
            do {
                long j = this.k.get();
                long j2 = 0;
                while (j2 != j) {
                    boolean z = this.l;
                    Object poll = spscLinkedArrayQueue.poll();
                    boolean z2 = poll == null;
                    if (a(z, z2, subscriber, spscLinkedArrayQueue)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    try {
                        subscriber.onNext((Object) ObjectHelper.requireNonNull(this.b.apply((Object[]) spscLinkedArrayQueue.poll()), "The combiner returned a null value"));
                        ((CombineLatestInnerSubscriber) poll).requestOne();
                        j2++;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        a();
                        ExceptionHelper.addThrowable(this.m, th);
                        subscriber.onError(ExceptionHelper.terminate(this.m));
                        return;
                    }
                }
                if (j2 == j && a(this.l, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                    return;
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.k.addAndGet(-j2);
                }
                i = addAndGet(-i);
            } while (i != 0);
        }

        void c() {
            Subscriber<? super R> subscriber = this.a;
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.d;
            int i = 1;
            while (!this.j) {
                Throwable th = this.m.get();
                if (th != null) {
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(th);
                    return;
                }
                boolean z = this.l;
                boolean isEmpty = spscLinkedArrayQueue.isEmpty();
                if (!isEmpty) {
                    subscriber.onNext(null);
                }
                if (z && isEmpty) {
                    subscriber.onComplete();
                    return;
                } else {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
            spscLinkedArrayQueue.clear();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.j = true;
            a();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.d.clear();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.g) {
                c();
            } else {
                b();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.d.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public R poll() {
            Object poll = this.d.poll();
            if (poll == null) {
                return null;
            }
            R r = (R) ObjectHelper.requireNonNull(this.b.apply((Object[]) this.d.poll()), "The combiner returned a null value");
            ((CombineLatestInnerSubscriber) poll).requestOne();
            return r;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.k, j);
                drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 4) != 0) {
                return 0;
            }
            int i2 = i & 2;
            this.g = i2 != 0;
            return i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class CombineLatestInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -8730235182291002949L;
        final CombineLatestCoordinator<T, ?> a;
        final int b;
        final int c;
        final int d;
        int e;

        CombineLatestInnerSubscriber(CombineLatestCoordinator<T, ?> combineLatestCoordinator, int i, int i2) {
            this.a = combineLatestCoordinator;
            this.b = i;
            this.c = i2;
            this.d = i2 - (i2 >> 2);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.a(this.b);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.a(this.b, th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.a.a(this.b, (int) t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, this.c);
        }

        public void requestOne() {
            int i = this.e + 1;
            if (i != this.d) {
                this.e = i;
            } else {
                this.e = 0;
                get().request(i);
            }
        }
    }

    /* loaded from: classes2.dex */
    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public R apply(T t) {
            return FlowableCombineLatest.this.d.apply(new Object[]{t});
        }
    }

    public FlowableCombineLatest(@NonNull Iterable<? extends Publisher<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.b = null;
        this.c = iterable;
        this.d = function;
        this.e = i;
        this.f = z;
    }

    public FlowableCombineLatest(@NonNull Publisher<? extends T>[] publisherArr, @NonNull Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.b = publisherArr;
        this.c = null;
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
            try {
                Iterator it = (Iterator) ObjectHelper.requireNonNull(this.c.iterator(), "The iterator returned is null");
                length = 0;
                while (it.hasNext()) {
                    try {
                        try {
                            Publisher<? extends T> publisher = (Publisher) ObjectHelper.requireNonNull(it.next(), "The publisher returned by the iterator is null");
                            if (length == publisherArr.length) {
                                Publisher<? extends T>[] publisherArr2 = new Publisher[(length >> 2) + length];
                                System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                                publisherArr = publisherArr2;
                            }
                            publisherArr[length] = publisher;
                            length++;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            EmptySubscription.error(th, subscriber);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        EmptySubscription.error(th2, subscriber);
                        return;
                    }
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                EmptySubscription.error(th3, subscriber);
                return;
            }
        } else {
            length = publisherArr.length;
        }
        if (length == 0) {
            EmptySubscription.complete(subscriber);
            return;
        }
        if (length == 1) {
            publisherArr[0].subscribe(new FlowableMap.MapSubscriber(subscriber, new SingletonArrayFunc()));
            return;
        }
        CombineLatestCoordinator combineLatestCoordinator = new CombineLatestCoordinator(subscriber, this.d, length, this.e, this.f);
        subscriber.onSubscribe(combineLatestCoordinator);
        combineLatestCoordinator.a(publisherArr, length);
    }
}
