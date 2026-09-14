package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableConcatMap<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super T, ? extends Publisher<? extends R>> c;
    final int d;
    final ErrorMode e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.internal.operators.flowable.FlowableConcatMap$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[ErrorMode.values().length];

        static {
            try {
                a[ErrorMode.BOUNDARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ErrorMode.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class BaseConcatMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, ConcatMapSupport<R>, Subscription {
        private static final long serialVersionUID = -3511336836796789179L;
        final Function<? super T, ? extends Publisher<? extends R>> b;
        final int c;
        final int d;
        Subscription e;
        int f;
        SimpleQueue<T> g;
        volatile boolean h;
        volatile boolean i;
        volatile boolean k;
        int l;
        final ConcatMapInner<R> a = new ConcatMapInner<>(this);
        final AtomicThrowable j = new AtomicThrowable();

        BaseConcatMapSubscriber(Function<? super T, ? extends Publisher<? extends R>> function, int i) {
            this.b = function;
            this.c = i;
            this.d = i - (i >> 2);
        }

        abstract void a();

        abstract void b();

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public final void innerComplete() {
            this.k = false;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.h = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.l == 2 || this.g.offer(t)) {
                a();
            } else {
                this.e.cancel();
                onError(new IllegalStateException("Queue full?!"));
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                this.e = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.l = requestFusion;
                        this.g = queueSubscription;
                        this.h = true;
                        b();
                        a();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.l = requestFusion;
                        this.g = queueSubscription;
                        b();
                        subscription.request(this.c);
                        return;
                    }
                }
                this.g = new SpscArrayQueue(this.c);
                b();
                subscription.request(this.c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class ConcatMapDelayed<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = -2945777694260521066L;
        final Subscriber<? super R> m;
        final boolean n;

        ConcatMapDelayed(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i, boolean z) {
            super(function, i);
            this.m = subscriber;
            this.n = z;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void a() {
            if (getAndIncrement() == 0) {
                while (!this.i) {
                    if (!this.k) {
                        boolean z = this.h;
                        if (!z || this.n || this.j.get() == null) {
                            try {
                                T poll = this.g.poll();
                                boolean z2 = poll == null;
                                if (z && z2) {
                                    Throwable terminate = this.j.terminate();
                                    if (terminate != null) {
                                        this.m.onError(terminate);
                                        return;
                                    } else {
                                        this.m.onComplete();
                                        return;
                                    }
                                }
                                if (!z2) {
                                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.b.apply(poll), "The mapper returned a null Publisher");
                                    if (this.l != 1) {
                                        int i = this.f + 1;
                                        if (i == this.d) {
                                            this.f = 0;
                                            this.e.request(i);
                                        } else {
                                            this.f = i;
                                        }
                                    }
                                    if (publisher instanceof Callable) {
                                        Object call = ((Callable) publisher).call();
                                        if (call == null) {
                                            continue;
                                        } else if (this.a.isUnbounded()) {
                                            this.m.onNext(call);
                                        } else {
                                            this.k = true;
                                            ConcatMapInner<R> concatMapInner = this.a;
                                            concatMapInner.setSubscription(new WeakScalarSubscription(call, concatMapInner));
                                        }
                                    } else {
                                        this.k = true;
                                        publisher.subscribe(this.a);
                                    }
                                }
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.e.cancel();
                                this.j.addThrowable(th);
                            }
                        }
                        this.m.onError(this.j.terminate());
                        return;
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void b() {
            this.m.onSubscribe(this);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.i) {
                return;
            }
            this.i = true;
            this.a.cancel();
            this.e.cancel();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void innerError(Throwable th) {
            if (!this.j.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (!this.n) {
                this.e.cancel();
                this.h = true;
            }
            this.k = false;
            a();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void innerNext(R r) {
            this.m.onNext(r);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.j.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.h = true;
                a();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.a.request(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class ConcatMapImmediate<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = 7898995095634264146L;
        final Subscriber<? super R> m;
        final AtomicInteger n;

        ConcatMapImmediate(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i) {
            super(function, i);
            this.m = subscriber;
            this.n = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void a() {
            if (this.n.getAndIncrement() == 0) {
                while (!this.i) {
                    if (!this.k) {
                        boolean z = this.h;
                        try {
                            T poll = this.g.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.m.onComplete();
                                return;
                            }
                            if (!z2) {
                                try {
                                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.b.apply(poll), "The mapper returned a null Publisher");
                                    if (this.l != 1) {
                                        int i = this.f + 1;
                                        if (i == this.d) {
                                            this.f = 0;
                                            this.e.request(i);
                                        } else {
                                            this.f = i;
                                        }
                                    }
                                    if (publisher instanceof Callable) {
                                        try {
                                            Object call = ((Callable) publisher).call();
                                            if (call == null) {
                                                continue;
                                            } else if (!this.a.isUnbounded()) {
                                                this.k = true;
                                                ConcatMapInner<R> concatMapInner = this.a;
                                                concatMapInner.setSubscription(new WeakScalarSubscription(call, concatMapInner));
                                            } else if (get() == 0 && compareAndSet(0, 1)) {
                                                this.m.onNext(call);
                                                if (!compareAndSet(1, 0)) {
                                                    this.m.onError(this.j.terminate());
                                                    return;
                                                }
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.throwIfFatal(th);
                                            this.e.cancel();
                                            this.j.addThrowable(th);
                                            this.m.onError(this.j.terminate());
                                            return;
                                        }
                                    } else {
                                        this.k = true;
                                        publisher.subscribe(this.a);
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    this.e.cancel();
                                    this.j.addThrowable(th2);
                                    this.m.onError(this.j.terminate());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            this.e.cancel();
                            this.j.addThrowable(th3);
                            this.m.onError(this.j.terminate());
                            return;
                        }
                    }
                    if (this.n.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void b() {
            this.m.onSubscribe(this);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.i) {
                return;
            }
            this.i = true;
            this.a.cancel();
            this.e.cancel();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void innerError(Throwable th) {
            if (!this.j.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.e.cancel();
            if (getAndIncrement() == 0) {
                this.m.onError(this.j.terminate());
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void innerNext(R r) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.m.onNext(r);
                if (compareAndSet(1, 0)) {
                    return;
                }
                this.m.onError(this.j.terminate());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.j.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.a.cancel();
            if (getAndIncrement() == 0) {
                this.m.onError(this.j.terminate());
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.a.request(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class ConcatMapInner<R> extends SubscriptionArbiter implements FlowableSubscriber<R> {
        private static final long serialVersionUID = 897683679971470653L;
        final ConcatMapSupport<R> h;
        long i;

        ConcatMapInner(ConcatMapSupport<R> concatMapSupport) {
            this.h = concatMapSupport;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            long j = this.i;
            if (j != 0) {
                this.i = 0L;
                produced(j);
            }
            this.h.innerComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            long j = this.i;
            if (j != 0) {
                this.i = 0L;
                produced(j);
            }
            this.h.innerError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(R r) {
            this.i++;
            this.h.innerNext(r);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            setSubscription(subscription);
        }
    }

    /* loaded from: classes2.dex */
    interface ConcatMapSupport<T> {
        void innerComplete();

        void innerError(Throwable th);

        void innerNext(T t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class WeakScalarSubscription<T> implements Subscription {
        final Subscriber<? super T> a;
        final T b;
        boolean c;

        WeakScalarSubscription(T t, Subscriber<? super T> subscriber) {
            this.b = t;
            this.a = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (j <= 0 || this.c) {
                return;
            }
            this.c = true;
            Subscriber<? super T> subscriber = this.a;
            subscriber.onNext(this.b);
            subscriber.onComplete();
        }
    }

    public FlowableConcatMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i, ErrorMode errorMode) {
        super(flowable);
        this.c = function;
        this.d = i;
        this.e = errorMode;
    }

    public static <T, R> Subscriber<T> subscribe(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i, ErrorMode errorMode) {
        int i2 = AnonymousClass1.a[errorMode.ordinal()];
        return i2 != 1 ? i2 != 2 ? new ConcatMapImmediate(subscriber, function, i) : new ConcatMapDelayed(subscriber, function, i, true) : new ConcatMapDelayed(subscriber, function, i, false);
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> subscriber) {
        if (FlowableScalarXMap.tryScalarXMapSubscribe(this.b, subscriber, this.c)) {
            return;
        }
        this.b.subscribe(subscribe(subscriber, this.c, this.d, this.e));
    }
}
