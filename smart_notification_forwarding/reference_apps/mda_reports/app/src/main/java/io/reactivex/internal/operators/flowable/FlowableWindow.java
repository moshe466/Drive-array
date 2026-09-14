package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableWindow<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final long c;
    final long d;
    final int e;

    /* loaded from: classes2.dex */
    static final class WindowExactSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -2365647875069161133L;
        final Subscriber<? super Flowable<T>> a;
        final long b;
        final AtomicBoolean c;
        final int d;
        long e;
        Subscription f;
        UnicastProcessor<T> g;

        WindowExactSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, int i) {
            super(1);
            this.a = subscriber;
            this.b = j;
            this.c = new AtomicBoolean();
            this.d = i;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.c.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            UnicastProcessor<T> unicastProcessor = this.g;
            if (unicastProcessor != null) {
                this.g = null;
                unicastProcessor.onComplete();
            }
            this.a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            UnicastProcessor<T> unicastProcessor = this.g;
            if (unicastProcessor != null) {
                this.g = null;
                unicastProcessor.onError(th);
            }
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j = this.e;
            UnicastProcessor<T> unicastProcessor = this.g;
            if (j == 0) {
                getAndIncrement();
                unicastProcessor = UnicastProcessor.create(this.d, this);
                this.g = unicastProcessor;
                this.a.onNext(unicastProcessor);
            }
            long j2 = j + 1;
            unicastProcessor.onNext(t);
            if (j2 != this.b) {
                this.e = j2;
                return;
            }
            this.e = 0L;
            this.g = null;
            unicastProcessor.onComplete();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                this.f.request(BackpressureHelper.multiplyCap(this.b, j));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.f.cancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class WindowOverlapSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 2428527070996323976L;
        final Subscriber<? super Flowable<T>> a;
        final SpscLinkedArrayQueue<UnicastProcessor<T>> b;
        final long c;
        final long d;
        final ArrayDeque<UnicastProcessor<T>> e;
        final AtomicBoolean f;
        final AtomicBoolean g;
        final AtomicLong h;
        final AtomicInteger i;
        final int j;
        long k;
        long l;
        Subscription m;
        volatile boolean n;
        Throwable o;
        volatile boolean p;

        WindowOverlapSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, long j2, int i) {
            super(1);
            this.a = subscriber;
            this.c = j;
            this.d = j2;
            this.b = new SpscLinkedArrayQueue<>(i);
            this.e = new ArrayDeque<>();
            this.f = new AtomicBoolean();
            this.g = new AtomicBoolean();
            this.h = new AtomicLong();
            this.i = new AtomicInteger();
            this.j = i;
        }

        void a() {
            if (this.i.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super Flowable<T>> subscriber = this.a;
            SpscLinkedArrayQueue<UnicastProcessor<T>> spscLinkedArrayQueue = this.b;
            int i = 1;
            do {
                long j = this.h.get();
                long j2 = 0;
                while (j2 != j) {
                    boolean z = this.n;
                    UnicastProcessor<T> poll = spscLinkedArrayQueue.poll();
                    boolean z2 = poll == null;
                    if (a(z, z2, subscriber, spscLinkedArrayQueue)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.onNext(poll);
                    j2++;
                }
                if (j2 == j && a(this.n, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                    return;
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.h.addAndGet(-j2);
                }
                i = this.i.addAndGet(-i);
            } while (i != 0);
        }

        boolean a(boolean z, boolean z2, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            if (this.p) {
                spscLinkedArrayQueue.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.o;
            if (th != null) {
                spscLinkedArrayQueue.clear();
                subscriber.onError(th);
                return true;
            }
            if (!z2) {
                return false;
            }
            subscriber.onComplete();
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.p = true;
            if (this.f.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.n) {
                return;
            }
            Iterator<UnicastProcessor<T>> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().onComplete();
            }
            this.e.clear();
            this.n = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.n) {
                RxJavaPlugins.onError(th);
                return;
            }
            Iterator<UnicastProcessor<T>> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().onError(th);
            }
            this.e.clear();
            this.o = th;
            this.n = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.n) {
                return;
            }
            long j = this.k;
            if (j == 0 && !this.p) {
                getAndIncrement();
                UnicastProcessor<T> create = UnicastProcessor.create(this.j, this);
                this.e.offer(create);
                this.b.offer(create);
                a();
            }
            long j2 = j + 1;
            Iterator<UnicastProcessor<T>> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            long j3 = this.l + 1;
            if (j3 == this.c) {
                this.l = j3 - this.d;
                UnicastProcessor<T> poll = this.e.poll();
                if (poll != null) {
                    poll.onComplete();
                }
            } else {
                this.l = j3;
            }
            if (j2 == this.d) {
                this.k = 0L;
            } else {
                this.k = j2;
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.m, subscription)) {
                this.m = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            long multiplyCap;
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.h, j);
                if (this.g.get() || !this.g.compareAndSet(false, true)) {
                    multiplyCap = BackpressureHelper.multiplyCap(this.d, j);
                } else {
                    multiplyCap = BackpressureHelper.addCap(this.c, BackpressureHelper.multiplyCap(this.d, j - 1));
                }
                this.m.request(multiplyCap);
                a();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.m.cancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class WindowSkipSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -8792836352386833856L;
        final Subscriber<? super Flowable<T>> a;
        final long b;
        final long c;
        final AtomicBoolean d;
        final AtomicBoolean e;
        final int f;
        long g;
        Subscription h;
        UnicastProcessor<T> i;

        WindowSkipSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, long j2, int i) {
            super(1);
            this.a = subscriber;
            this.b = j;
            this.c = j2;
            this.d = new AtomicBoolean();
            this.e = new AtomicBoolean();
            this.f = i;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.d.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            UnicastProcessor<T> unicastProcessor = this.i;
            if (unicastProcessor != null) {
                this.i = null;
                unicastProcessor.onComplete();
            }
            this.a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            UnicastProcessor<T> unicastProcessor = this.i;
            if (unicastProcessor != null) {
                this.i = null;
                unicastProcessor.onError(th);
            }
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            long j = this.g;
            UnicastProcessor<T> unicastProcessor = this.i;
            if (j == 0) {
                getAndIncrement();
                unicastProcessor = UnicastProcessor.create(this.f, this);
                this.i = unicastProcessor;
                this.a.onNext(unicastProcessor);
            }
            long j2 = j + 1;
            if (unicastProcessor != null) {
                unicastProcessor.onNext(t);
            }
            if (j2 == this.b) {
                this.i = null;
                unicastProcessor.onComplete();
            }
            if (j2 == this.c) {
                this.g = 0L;
            } else {
                this.g = j2;
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.h, subscription)) {
                this.h = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                this.h.request((this.e.get() || !this.e.compareAndSet(false, true)) ? BackpressureHelper.multiplyCap(this.c, j) : BackpressureHelper.addCap(BackpressureHelper.multiplyCap(this.b, j), BackpressureHelper.multiplyCap(this.c - this.b, j - 1)));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.h.cancel();
            }
        }
    }

    public FlowableWindow(Flowable<T> flowable, long j, long j2, int i) {
        super(flowable);
        this.c = j;
        this.d = j2;
        this.e = i;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        long j = this.d;
        long j2 = this.c;
        if (j == j2) {
            this.b.subscribe((FlowableSubscriber) new WindowExactSubscriber(subscriber, j2, this.e));
        } else {
            this.b.subscribe((FlowableSubscriber) (j > j2 ? new WindowSkipSubscriber<>(subscriber, j2, j, this.e) : new WindowOverlapSubscriber<>(subscriber, j2, j, this.e)));
        }
    }
}
