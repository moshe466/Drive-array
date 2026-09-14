package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableWindowBoundarySupplier<T, B> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final Callable<? extends Publisher<B>> c;
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
            this.b.c();
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
            this.c = true;
            dispose();
            this.b.a(this);
        }
    }

    /* loaded from: classes2.dex */
    static final class WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        static final WindowBoundaryInnerSubscriber<Object, Object> n = new WindowBoundaryInnerSubscriber<>(null);
        static final Object o = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        final Subscriber<? super Flowable<T>> a;
        final int b;
        final Callable<? extends Publisher<B>> h;
        Subscription j;
        volatile boolean k;
        UnicastProcessor<T> l;
        long m;
        final AtomicReference<WindowBoundaryInnerSubscriber<T, B>> c = new AtomicReference<>();
        final AtomicInteger d = new AtomicInteger(1);
        final MpscLinkedQueue<Object> e = new MpscLinkedQueue<>();
        final AtomicThrowable f = new AtomicThrowable();
        final AtomicBoolean g = new AtomicBoolean();
        final AtomicLong i = new AtomicLong();

        WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> subscriber, int i, Callable<? extends Publisher<B>> callable) {
            this.a = subscriber;
            this.b = i;
            this.h = callable;
        }

        void a() {
            Disposable disposable = (Disposable) this.c.getAndSet(n);
            if (disposable == null || disposable == n) {
                return;
            }
            disposable.dispose();
        }

        void a(WindowBoundaryInnerSubscriber<T, B> windowBoundaryInnerSubscriber) {
            this.c.compareAndSet(windowBoundaryInnerSubscriber, null);
            this.e.offer(o);
            b();
        }

        void a(Throwable th) {
            this.j.cancel();
            if (!this.f.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.k = true;
                b();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void b() {
            MissingBackpressureException th;
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super Flowable<T>> subscriber = this.a;
            MpscLinkedQueue<Object> mpscLinkedQueue = this.e;
            AtomicThrowable atomicThrowable = this.f;
            long j = this.m;
            int i = 1;
            while (this.d.get() != 0) {
                UnicastProcessor<T> unicastProcessor = this.l;
                boolean z = this.k;
                if (z && atomicThrowable.get() != null) {
                    mpscLinkedQueue.clear();
                    Throwable terminate = atomicThrowable.terminate();
                    if (unicastProcessor != 0) {
                        this.l = null;
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
                            this.l = null;
                            unicastProcessor.onComplete();
                        }
                        subscriber.onComplete();
                        return;
                    }
                    if (unicastProcessor != 0) {
                        this.l = null;
                        unicastProcessor.onError(terminate2);
                    }
                    subscriber.onError(terminate2);
                    return;
                }
                if (z2) {
                    this.m = j;
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (poll != o) {
                    unicastProcessor.onNext(poll);
                } else {
                    if (unicastProcessor != 0) {
                        this.l = null;
                        unicastProcessor.onComplete();
                    }
                    if (!this.g.get()) {
                        if (j != this.i.get()) {
                            UnicastProcessor<T> create = UnicastProcessor.create(this.b, this);
                            this.l = create;
                            this.d.getAndIncrement();
                            try {
                                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.h.call(), "The other Callable returned a null Publisher");
                                WindowBoundaryInnerSubscriber<T, B> windowBoundaryInnerSubscriber = new WindowBoundaryInnerSubscriber<>(this);
                                if (this.c.compareAndSet(null, windowBoundaryInnerSubscriber)) {
                                    publisher.subscribe(windowBoundaryInnerSubscriber);
                                    j++;
                                    subscriber.onNext(create);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                Exceptions.throwIfFatal(th);
                            }
                        } else {
                            this.j.cancel();
                            a();
                            th = new MissingBackpressureException("Could not deliver a window due to lack of requests");
                        }
                        atomicThrowable.addThrowable(th);
                        this.k = true;
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.l = null;
        }

        void c() {
            this.j.cancel();
            this.k = true;
            b();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.g.compareAndSet(false, true)) {
                a();
                if (this.d.decrementAndGet() == 0) {
                    this.j.cancel();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            a();
            this.k = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            a();
            if (!this.f.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.k = true;
                b();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.e.offer(t);
            b();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.j, subscription)) {
                this.j = subscription;
                this.a.onSubscribe(this);
                this.e.offer(o);
                b();
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            BackpressureHelper.add(this.i, j);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.d.decrementAndGet() == 0) {
                this.j.cancel();
            }
        }
    }

    public FlowableWindowBoundarySupplier(Flowable<T> flowable, Callable<? extends Publisher<B>> callable, int i) {
        super(flowable);
        this.c = callable;
        this.d = i;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        this.b.subscribe((FlowableSubscriber) new WindowBoundaryMainSubscriber(subscriber, this.d, this.c));
    }
}
