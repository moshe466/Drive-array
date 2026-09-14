package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableFlatMap<T, U> extends AbstractFlowableWithUpstream<T, U> {
    final Function<? super T, ? extends Publisher<? extends U>> c;
    final boolean d;
    final int e;
    final int f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class InnerSubscriber<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<U>, Disposable {
        private static final long serialVersionUID = -4606175640614850599L;
        final long a;
        final MergeSubscriber<T, U> b;
        final int c;
        final int d;
        volatile boolean e;
        volatile SimpleQueue<U> f;
        long g;
        int h;

        InnerSubscriber(MergeSubscriber<T, U> mergeSubscriber, long j) {
            this.a = j;
            this.b = mergeSubscriber;
            this.d = mergeSubscriber.e;
            this.c = this.d >> 2;
        }

        void a(long j) {
            if (this.h != 1) {
                long j2 = this.g + j;
                if (j2 < this.c) {
                    this.g = j2;
                } else {
                    this.g = 0L;
                    get().request(j2);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.e = true;
            this.b.d();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            lazySet(SubscriptionHelper.CANCELLED);
            this.b.a(this, th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(U u) {
            if (this.h != 2) {
                this.b.a((MergeSubscriber<T, U>) u, (InnerSubscriber<T, MergeSubscriber<T, U>>) this);
            } else {
                this.b.d();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.h = requestFusion;
                        this.f = queueSubscription;
                        this.e = true;
                        this.b.d();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.h = requestFusion;
                        this.f = queueSubscription;
                    }
                }
                subscription.request(this.d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class MergeSubscriber<T, U> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        static final InnerSubscriber<?, ?>[] r = new InnerSubscriber[0];
        static final InnerSubscriber<?, ?>[] s = new InnerSubscriber[0];
        private static final long serialVersionUID = -2117620485640801370L;
        final Subscriber<? super U> a;
        final Function<? super T, ? extends Publisher<? extends U>> b;
        final boolean c;
        final int d;
        final int e;
        volatile SimplePlainQueue<U> f;
        volatile boolean g;
        volatile boolean i;
        Subscription l;
        long m;
        long n;
        int o;
        int p;
        final int q;
        final AtomicThrowable h = new AtomicThrowable();
        final AtomicReference<InnerSubscriber<?, ?>[]> j = new AtomicReference<>();
        final AtomicLong k = new AtomicLong();

        MergeSubscriber(Subscriber<? super U> subscriber, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i, int i2) {
            this.a = subscriber;
            this.b = function;
            this.c = z;
            this.d = i;
            this.e = i2;
            this.q = Math.max(1, i >> 1);
            this.j.lazySet(r);
        }

        void a(InnerSubscriber<T, U> innerSubscriber, Throwable th) {
            if (!this.h.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            innerSubscriber.e = true;
            if (!this.c) {
                this.l.cancel();
                for (InnerSubscriber<?, ?> innerSubscriber2 : this.j.getAndSet(s)) {
                    innerSubscriber2.dispose();
                }
            }
            d();
        }

        void a(U u) {
            IllegalStateException illegalStateException;
            if (get() != 0 || !compareAndSet(0, 1)) {
                if (!f().offer(u)) {
                    illegalStateException = new IllegalStateException("Scalar queue full?!");
                    onError(illegalStateException);
                    return;
                } else {
                    if (getAndIncrement() != 0) {
                        return;
                    }
                    e();
                }
            }
            long j = this.k.get();
            SimpleQueue<U> simpleQueue = this.f;
            if (j == 0 || !(simpleQueue == null || simpleQueue.isEmpty())) {
                if (simpleQueue == null) {
                    simpleQueue = f();
                }
                if (!simpleQueue.offer(u)) {
                    illegalStateException = new IllegalStateException("Scalar queue full?!");
                    onError(illegalStateException);
                    return;
                }
            } else {
                this.a.onNext(u);
                if (j != Long.MAX_VALUE) {
                    this.k.decrementAndGet();
                }
                if (this.d != Integer.MAX_VALUE && !this.i) {
                    int i = this.p + 1;
                    this.p = i;
                    int i2 = this.q;
                    if (i == i2) {
                        this.p = 0;
                        this.l.request(i2);
                    }
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
            e();
        }

        void a(U u, InnerSubscriber<T, U> innerSubscriber) {
            MissingBackpressureException missingBackpressureException;
            if (get() != 0 || !compareAndSet(0, 1)) {
                SimpleQueue simpleQueue = innerSubscriber.f;
                if (simpleQueue == null) {
                    simpleQueue = new SpscArrayQueue(this.e);
                    innerSubscriber.f = simpleQueue;
                }
                if (!simpleQueue.offer(u)) {
                    missingBackpressureException = new MissingBackpressureException("Inner queue full?!");
                    onError(missingBackpressureException);
                    return;
                } else {
                    if (getAndIncrement() != 0) {
                        return;
                    }
                    e();
                }
            }
            long j = this.k.get();
            SimpleQueue<U> simpleQueue2 = innerSubscriber.f;
            if (j == 0 || !(simpleQueue2 == null || simpleQueue2.isEmpty())) {
                if (simpleQueue2 == null) {
                    simpleQueue2 = b(innerSubscriber);
                }
                if (!simpleQueue2.offer(u)) {
                    missingBackpressureException = new MissingBackpressureException("Inner queue full?!");
                    onError(missingBackpressureException);
                    return;
                }
            } else {
                this.a.onNext(u);
                if (j != Long.MAX_VALUE) {
                    this.k.decrementAndGet();
                }
                innerSubscriber.a(1L);
            }
            if (decrementAndGet() == 0) {
                return;
            }
            e();
        }

        boolean a() {
            if (this.i) {
                b();
                return true;
            }
            if (this.c || this.h.get() == null) {
                return false;
            }
            b();
            Throwable terminate = this.h.terminate();
            if (terminate != ExceptionHelper.TERMINATED) {
                this.a.onError(terminate);
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean a(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.j.get();
                if (innerSubscriberArr == s) {
                    innerSubscriber.dispose();
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new InnerSubscriber[length + 1];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!this.j.compareAndSet(innerSubscriberArr, innerSubscriberArr2));
            return true;
        }

        SimpleQueue<U> b(InnerSubscriber<T, U> innerSubscriber) {
            SimpleQueue<U> simpleQueue = innerSubscriber.f;
            if (simpleQueue != null) {
                return simpleQueue;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.e);
            innerSubscriber.f = spscArrayQueue;
            return spscArrayQueue;
        }

        void b() {
            SimplePlainQueue<U> simplePlainQueue = this.f;
            if (simplePlainQueue != null) {
                simplePlainQueue.clear();
            }
        }

        void c() {
            InnerSubscriber<?, ?>[] andSet;
            InnerSubscriber<?, ?>[] innerSubscriberArr = this.j.get();
            InnerSubscriber<?, ?>[] innerSubscriberArr2 = s;
            if (innerSubscriberArr == innerSubscriberArr2 || (andSet = this.j.getAndSet(innerSubscriberArr2)) == s) {
                return;
            }
            for (InnerSubscriber<?, ?> innerSubscriber : andSet) {
                innerSubscriber.dispose();
            }
            Throwable terminate = this.h.terminate();
            if (terminate == null || terminate == ExceptionHelper.TERMINATED) {
                return;
            }
            RxJavaPlugins.onError(terminate);
        }

        /* JADX WARN: Multi-variable type inference failed */
        void c(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber<?, ?>[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.j.get();
                int length = innerSubscriberArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (innerSubscriberArr[i2] == innerSubscriber) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriberArr2 = r;
                } else {
                    InnerSubscriber<?, ?>[] innerSubscriberArr3 = new InnerSubscriber[length - 1];
                    System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i);
                    System.arraycopy(innerSubscriberArr, i + 1, innerSubscriberArr3, i, (length - i) - 1);
                    innerSubscriberArr2 = innerSubscriberArr3;
                }
            } while (!this.j.compareAndSet(innerSubscriberArr, innerSubscriberArr2));
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SimplePlainQueue<U> simplePlainQueue;
            if (this.i) {
                return;
            }
            this.i = true;
            this.l.cancel();
            c();
            if (getAndIncrement() != 0 || (simplePlainQueue = this.f) == null) {
                return;
            }
            simplePlainQueue.clear();
        }

        void d() {
            if (getAndIncrement() == 0) {
                e();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:104:0x0196, code lost:
        
            r24.o = r4;
            r24.n = r11[r4].a;
            r3 = r16;
            r5 = 0;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void e() {
            /*
                Method dump skipped, instructions count: 454
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlatMap.MergeSubscriber.e():void");
        }

        SimpleQueue<U> f() {
            SimplePlainQueue<U> simplePlainQueue = this.f;
            if (simplePlainQueue == null) {
                int i = this.d;
                simplePlainQueue = i == Integer.MAX_VALUE ? new SpscLinkedArrayQueue<>(this.e) : new SpscArrayQueue(i);
                this.f = simplePlainQueue;
            }
            return simplePlainQueue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.g) {
                return;
            }
            this.g = true;
            d();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.g) {
                RxJavaPlugins.onError(th);
            } else if (!this.h.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.g = true;
                d();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.g) {
                return;
            }
            try {
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.b.apply(t), "The mapper returned a null Publisher");
                if (!(publisher instanceof Callable)) {
                    long j = this.m;
                    this.m = 1 + j;
                    InnerSubscriber innerSubscriber = new InnerSubscriber(this, j);
                    if (a(innerSubscriber)) {
                        publisher.subscribe(innerSubscriber);
                        return;
                    }
                    return;
                }
                try {
                    Object call = ((Callable) publisher).call();
                    if (call != null) {
                        a((MergeSubscriber<T, U>) call);
                        return;
                    }
                    if (this.d == Integer.MAX_VALUE || this.i) {
                        return;
                    }
                    int i = this.p + 1;
                    this.p = i;
                    int i2 = this.q;
                    if (i == i2) {
                        this.p = 0;
                        this.l.request(i2);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.h.addThrowable(th);
                    d();
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.l.cancel();
                onError(th2);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.l, subscription)) {
                this.l = subscription;
                this.a.onSubscribe(this);
                if (this.i) {
                    return;
                }
                int i = this.d;
                subscription.request(i == Integer.MAX_VALUE ? Long.MAX_VALUE : i);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.k, j);
                d();
            }
        }
    }

    public FlowableFlatMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i, int i2) {
        super(flowable);
        this.c = function;
        this.d = z;
        this.e = i;
        this.f = i2;
    }

    public static <T, U> FlowableSubscriber<T> subscribe(Subscriber<? super U> subscriber, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i, int i2) {
        return new MergeSubscriber(subscriber, function, z, i, i2);
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super U> subscriber) {
        if (FlowableScalarXMap.tryScalarXMapSubscribe(this.b, subscriber, this.c)) {
            return;
        }
        this.b.subscribe((FlowableSubscriber) subscribe(subscriber, this.c, this.d, this.e, this.f));
    }
}
