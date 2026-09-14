package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableWindowBoundary<T, B> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final Publisher<B> c;
    final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class WindowBoundaryInnerSubscriber<T, B> extends DisposableSubscriber<B> {
        final WindowBoundaryMainSubscriber<T, B> b;
        boolean c;

        WindowBoundaryInnerSubscriber(WindowBoundaryMainSubscriber<T, B> windowBoundaryMainSubscriber) {
            this.b = windowBoundaryMainSubscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.c) {
                return;
            }
            this.c = true;
            this.b.b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.c) {
                RxJavaPlugins.onError(th);
            } else {
                this.c = true;
                this.b.a(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(B b) {
            if (this.c) {
                return;
            }
            this.b.c();
        }
    }

    /* loaded from: classes2.dex */
    static final class WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        static final Object m = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        final Subscriber<? super Flowable<T>> a;
        final int b;
        final WindowBoundaryInnerSubscriber<T, B> c = new WindowBoundaryInnerSubscriber<>(this);
        final AtomicReference<Subscription> d = new AtomicReference<>();
        final AtomicInteger e = new AtomicInteger(1);
        final MpscLinkedQueue<Object> f = new MpscLinkedQueue<>();
        final AtomicThrowable g = new AtomicThrowable();
        final AtomicBoolean h = new AtomicBoolean();
        final AtomicLong i = new AtomicLong();
        volatile boolean j;
        UnicastProcessor<T> k;
        long l;

        WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> subscriber, int i) {
            this.a = subscriber;
            this.b = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super Flowable<T>> subscriber = this.a;
            MpscLinkedQueue<Object> mpscLinkedQueue = this.f;
            AtomicThrowable atomicThrowable = this.g;
            long j = this.l;
            int i = 1;
            while (this.e.get() != 0) {
                UnicastProcessor<T> unicastProcessor = this.k;
                boolean z = this.j;
                if (z && atomicThrowable.get() != null) {
                    mpscLinkedQueue.clear();
                    Throwable terminate = atomicThrowable.terminate();
                    if (unicastProcessor != 0) {
                        this.k = null;
                        unicastProcessor.onError(terminate);
                    }
                    subscriber.onError(terminate);
                    return;
                }
                Object poll = mpscLinkedQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    Throwable terminate2 = atomicThrowable.terminate();
                    if (terminate2 == null) {
                        if (unicastProcessor != 0) {
                            this.k = null;
                            unicastProcessor.onComplete();
                        }
                        subscriber.onComplete();
                        return;
                    }
                    if (unicastProcessor != 0) {
                        this.k = null;
                        unicastProcessor.onError(terminate2);
                    }
                    subscriber.onError(terminate2);
                    return;
                }
                if (z2) {
                    this.l = j;
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (poll != m) {
                    unicastProcessor.onNext(poll);
                } else {
                    if (unicastProcessor != 0) {
                        this.k = null;
                        unicastProcessor.onComplete();
                    }
                    if (!this.h.get()) {
                        UnicastProcessor<T> create = UnicastProcessor.create(this.b, this);
                        this.k = create;
                        this.e.getAndIncrement();
                        if (j != this.i.get()) {
                            j++;
                            subscriber.onNext(create);
                        } else {
                            SubscriptionHelper.cancel(this.d);
                            this.c.dispose();
                            atomicThrowable.addThrowable(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
                            this.j = true;
                        }
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.k = null;
        }

        void a(Throwable th) {
            SubscriptionHelper.cancel(this.d);
            if (!this.g.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.j = true;
                a();
            }
        }

        void b() {
            SubscriptionHelper.cancel(this.d);
            this.j = true;
            a();
        }

        void c() {
            this.f.offer(m);
            a();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.h.compareAndSet(false, true)) {
                this.c.dispose();
                if (this.e.decrementAndGet() == 0) {
                    SubscriptionHelper.cancel(this.d);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.c.dispose();
            this.j = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.c.dispose();
            if (!this.g.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.j = true;
                a();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.f.offer(t);
            a();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this.d, subscription, Long.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            BackpressureHelper.add(this.i, j);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.e.decrementAndGet() == 0) {
                SubscriptionHelper.cancel(this.d);
            }
        }
    }

    public FlowableWindowBoundary(Flowable<T> flowable, Publisher<B> publisher, int i) {
        super(flowable);
        this.c = publisher;
        this.d = i;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        WindowBoundaryMainSubscriber windowBoundaryMainSubscriber = new WindowBoundaryMainSubscriber(subscriber, this.d);
        subscriber.onSubscribe(windowBoundaryMainSubscriber);
        windowBoundaryMainSubscriber.c();
        this.c.subscribe(windowBoundaryMainSubscriber.c);
        this.b.subscribe((FlowableSubscriber) windowBoundaryMainSubscriber);
    }
}
