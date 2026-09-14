package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractFlowableWithUpstream<T, U> {
    final Callable<U> c;
    final Publisher<? extends Open> d;
    final Function<? super Open, ? extends Publisher<? extends Close>> e;

    /* loaded from: classes2.dex */
    static final class BufferBoundarySubscriber<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -8466418554264089604L;
        final Subscriber<? super C> a;
        final Callable<C> b;
        final Publisher<? extends Open> c;
        final Function<? super Open, ? extends Publisher<? extends Close>> d;
        volatile boolean i;
        volatile boolean k;
        long l;
        long n;
        final SpscLinkedArrayQueue<C> j = new SpscLinkedArrayQueue<>(Flowable.bufferSize());
        final CompositeDisposable e = new CompositeDisposable();
        final AtomicLong f = new AtomicLong();
        final AtomicReference<Subscription> g = new AtomicReference<>();
        Map<Long, C> m = new LinkedHashMap();
        final AtomicThrowable h = new AtomicThrowable();

        /* loaded from: classes2.dex */
        static final class BufferOpenSubscriber<Open> extends AtomicReference<Subscription> implements FlowableSubscriber<Open>, Disposable {
            private static final long serialVersionUID = -8498650778633225126L;
            final BufferBoundarySubscriber<?, ?, Open, ?> a;

            BufferOpenSubscriber(BufferBoundarySubscriber<?, ?, Open, ?> bufferBoundarySubscriber) {
                this.a = bufferBoundarySubscriber;
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
                lazySet(SubscriptionHelper.CANCELLED);
                this.a.a((BufferOpenSubscriber) this);
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                lazySet(SubscriptionHelper.CANCELLED);
                this.a.a(this, th);
            }

            @Override // org.reactivestreams.Subscriber
            public void onNext(Open open) {
                this.a.a((BufferBoundarySubscriber<?, ?, Open, ?>) open);
            }

            @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
            public void onSubscribe(Subscription subscription) {
                SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
            }
        }

        BufferBoundarySubscriber(Subscriber<? super C> subscriber, Publisher<? extends Open> publisher, Function<? super Open, ? extends Publisher<? extends Close>> function, Callable<C> callable) {
            this.a = subscriber;
            this.b = callable;
            this.c = publisher;
            this.d = function;
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            long j = this.n;
            Subscriber<? super C> subscriber = this.a;
            SpscLinkedArrayQueue<C> spscLinkedArrayQueue = this.j;
            int i = 1;
            loop0: do {
                long j2 = this.f.get();
                while (j != j2) {
                    if (!this.k) {
                        boolean z = this.i;
                        if (z && this.h.get() != null) {
                            break loop0;
                        }
                        C poll = spscLinkedArrayQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            subscriber.onComplete();
                            return;
                        } else {
                            if (z2) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j++;
                        }
                    } else {
                        spscLinkedArrayQueue.clear();
                        return;
                    }
                }
                if (j == j2) {
                    if (this.k) {
                        spscLinkedArrayQueue.clear();
                        return;
                    }
                    if (this.i) {
                        if (this.h.get() != null) {
                            spscLinkedArrayQueue.clear();
                            subscriber.onError(this.h.terminate());
                            return;
                        } else if (spscLinkedArrayQueue.isEmpty()) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                this.n = j;
                i = addAndGet(-i);
            } while (i != 0);
        }

        void a(Disposable disposable, Throwable th) {
            SubscriptionHelper.cancel(this.g);
            this.e.delete(disposable);
            onError(th);
        }

        void a(BufferOpenSubscriber<Open> bufferOpenSubscriber) {
            this.e.delete(bufferOpenSubscriber);
            if (this.e.size() == 0) {
                SubscriptionHelper.cancel(this.g);
                this.i = true;
                a();
            }
        }

        void a(BufferCloseSubscriber<T, C> bufferCloseSubscriber, long j) {
            boolean z;
            this.e.delete(bufferCloseSubscriber);
            if (this.e.size() == 0) {
                SubscriptionHelper.cancel(this.g);
                z = true;
            } else {
                z = false;
            }
            synchronized (this) {
                if (this.m == null) {
                    return;
                }
                this.j.offer(this.m.remove(Long.valueOf(j)));
                if (z) {
                    this.i = true;
                }
                a();
            }
        }

        void a(Open open) {
            try {
                Collection collection = (Collection) ObjectHelper.requireNonNull(this.b.call(), "The bufferSupplier returned a null Collection");
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.d.apply(open), "The bufferClose returned a null Publisher");
                long j = this.l;
                this.l = 1 + j;
                synchronized (this) {
                    Map<Long, C> map = this.m;
                    if (map == null) {
                        return;
                    }
                    map.put(Long.valueOf(j), collection);
                    BufferCloseSubscriber bufferCloseSubscriber = new BufferCloseSubscriber(this, j);
                    this.e.add(bufferCloseSubscriber);
                    publisher.subscribe(bufferCloseSubscriber);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                SubscriptionHelper.cancel(this.g);
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (SubscriptionHelper.cancel(this.g)) {
                this.k = true;
                this.e.dispose();
                synchronized (this) {
                    this.m = null;
                }
                if (getAndIncrement() != 0) {
                    this.j.clear();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.e.dispose();
            synchronized (this) {
                Map<Long, C> map = this.m;
                if (map == null) {
                    return;
                }
                Iterator<C> it = map.values().iterator();
                while (it.hasNext()) {
                    this.j.offer(it.next());
                }
                this.m = null;
                this.i = true;
                a();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.h.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.e.dispose();
            synchronized (this) {
                this.m = null;
            }
            this.i = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            synchronized (this) {
                Map<Long, C> map = this.m;
                if (map == null) {
                    return;
                }
                Iterator<C> it = map.values().iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.g, subscription)) {
                BufferOpenSubscriber bufferOpenSubscriber = new BufferOpenSubscriber(this);
                this.e.add(bufferOpenSubscriber);
                this.c.subscribe(bufferOpenSubscriber);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            BackpressureHelper.add(this.f, j);
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class BufferCloseSubscriber<T, C extends Collection<? super T>> extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = -8498650778633225126L;
        final BufferBoundarySubscriber<T, C, ?, ?> a;
        final long b;

        BufferCloseSubscriber(BufferBoundarySubscriber<T, C, ?, ?> bufferBoundarySubscriber, long j) {
            this.a = bufferBoundarySubscriber;
            this.b = j;
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
            Subscription subscription = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.a.a(this, this.b);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Subscription subscription = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription == subscriptionHelper) {
                RxJavaPlugins.onError(th);
            } else {
                lazySet(subscriptionHelper);
                this.a.a(this, th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(Object obj) {
            Subscription subscription = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                lazySet(subscriptionHelper);
                subscription.cancel();
                this.a.a(this, this.b);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public FlowableBufferBoundary(Flowable<T> flowable, Publisher<? extends Open> publisher, Function<? super Open, ? extends Publisher<? extends Close>> function, Callable<U> callable) {
        super(flowable);
        this.d = publisher;
        this.e = function;
        this.c = callable;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super U> subscriber) {
        BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(subscriber, this.d, this.e, this.c);
        subscriber.onSubscribe(bufferBoundarySubscriber);
        this.b.subscribe((FlowableSubscriber) bufferBoundarySubscriber);
    }
}
