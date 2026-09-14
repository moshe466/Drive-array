package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableBufferTimed<T, U extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, U> {
    final long c;
    final long d;
    final TimeUnit e;
    final Scheduler f;
    final Callable<U> g;
    final int h;
    final boolean i;

    /* loaded from: classes2.dex */
    static final class BufferExactBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {
        final Callable<U> h;
        final long i;
        final TimeUnit j;
        final int k;
        final boolean l;
        final Scheduler.Worker m;
        U n;
        Disposable o;
        Subscription p;
        long q;
        long r;

        BufferExactBoundedSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, long j, TimeUnit timeUnit, int i, boolean z, Scheduler.Worker worker) {
            super(subscriber, new MpscLinkedQueue());
            this.h = callable;
            this.i = j;
            this.j = timeUnit;
            this.k = i;
            this.l = z;
            this.m = worker;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public /* bridge */ /* synthetic */ boolean accept(Subscriber subscriber, Object obj) {
            return accept((Subscriber<? super Subscriber>) subscriber, (Subscriber) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean accept(Subscriber<? super U> subscriber, U u) {
            subscriber.onNext(u);
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.e) {
                return;
            }
            this.e = true;
            dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            synchronized (this) {
                this.n = null;
            }
            this.p.cancel();
            this.m.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.m.isDisposed();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.n;
                this.n = null;
            }
            this.d.offer(u);
            this.f = true;
            if (enter()) {
                QueueDrainHelper.drainMaxLoop(this.d, this.c, false, this, this);
            }
            this.m.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            synchronized (this) {
                this.n = null;
            }
            this.c.onError(th);
            this.m.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            synchronized (this) {
                U u = this.n;
                if (u == null) {
                    return;
                }
                u.add(t);
                if (u.size() < this.k) {
                    return;
                }
                this.n = null;
                this.q++;
                if (this.l) {
                    this.o.dispose();
                }
                b(u, false, this);
                try {
                    U u2 = (U) ObjectHelper.requireNonNull(this.h.call(), "The supplied buffer is null");
                    synchronized (this) {
                        this.n = u2;
                        this.r++;
                    }
                    if (this.l) {
                        Scheduler.Worker worker = this.m;
                        long j = this.i;
                        this.o = worker.schedulePeriodically(this, j, j, this.j);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    this.c.onError(th);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.p, subscription)) {
                this.p = subscription;
                try {
                    this.n = (U) ObjectHelper.requireNonNull(this.h.call(), "The supplied buffer is null");
                    this.c.onSubscribe(this);
                    Scheduler.Worker worker = this.m;
                    long j = this.i;
                    this.o = worker.schedulePeriodically(this, j, j, this.j);
                    subscription.request(Long.MAX_VALUE);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.m.dispose();
                    subscription.cancel();
                    EmptySubscription.error(th, this.c);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u = (U) ObjectHelper.requireNonNull(this.h.call(), "The supplied buffer is null");
                synchronized (this) {
                    U u2 = this.n;
                    if (u2 != null && this.q == this.r) {
                        this.n = u;
                        b(u2, false, this);
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                this.c.onError(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class BufferExactUnboundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {
        final Callable<U> h;
        final long i;
        final TimeUnit j;
        final Scheduler k;
        Subscription l;
        U m;
        final AtomicReference<Disposable> n;

        BufferExactUnboundedSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(subscriber, new MpscLinkedQueue());
            this.n = new AtomicReference<>();
            this.h = callable;
            this.i = j;
            this.j = timeUnit;
            this.k = scheduler;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public /* bridge */ /* synthetic */ boolean accept(Subscriber subscriber, Object obj) {
            return accept((Subscriber<? super Subscriber>) subscriber, (Subscriber) obj);
        }

        public boolean accept(Subscriber<? super U> subscriber, U u) {
            this.c.onNext(u);
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.e = true;
            this.l.cancel();
            DisposableHelper.dispose(this.n);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.n.get() == DisposableHelper.DISPOSED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            DisposableHelper.dispose(this.n);
            synchronized (this) {
                U u = this.m;
                if (u == null) {
                    return;
                }
                this.m = null;
                this.d.offer(u);
                this.f = true;
                if (enter()) {
                    QueueDrainHelper.drainMaxLoop(this.d, this.c, false, null, this);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.n);
            synchronized (this) {
                this.m = null;
            }
            this.c.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            synchronized (this) {
                U u = this.m;
                if (u != null) {
                    u.add(t);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.l, subscription)) {
                this.l = subscription;
                try {
                    this.m = (U) ObjectHelper.requireNonNull(this.h.call(), "The supplied buffer is null");
                    this.c.onSubscribe(this);
                    if (this.e) {
                        return;
                    }
                    subscription.request(Long.MAX_VALUE);
                    Scheduler scheduler = this.k;
                    long j = this.i;
                    Disposable schedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(this, j, j, this.j);
                    if (this.n.compareAndSet(null, schedulePeriodicallyDirect)) {
                        return;
                    }
                    schedulePeriodicallyDirect.dispose();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    EmptySubscription.error(th, this.c);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u = (U) ObjectHelper.requireNonNull(this.h.call(), "The supplied buffer is null");
                synchronized (this) {
                    U u2 = this.m;
                    if (u2 == null) {
                        return;
                    }
                    this.m = u;
                    a(u2, false, this);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                this.c.onError(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class BufferSkipBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable {
        final Callable<U> h;
        final long i;
        final long j;
        final TimeUnit k;
        final Scheduler.Worker l;
        final List<U> m;
        Subscription n;

        /* loaded from: classes2.dex */
        final class RemoveFromBuffer implements Runnable {
            private final U buffer;

            RemoveFromBuffer(U u) {
                this.buffer = u;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (BufferSkipBoundedSubscriber.this) {
                    BufferSkipBoundedSubscriber.this.m.remove(this.buffer);
                }
                BufferSkipBoundedSubscriber bufferSkipBoundedSubscriber = BufferSkipBoundedSubscriber.this;
                bufferSkipBoundedSubscriber.b(this.buffer, false, bufferSkipBoundedSubscriber.l);
            }
        }

        BufferSkipBoundedSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker) {
            super(subscriber, new MpscLinkedQueue());
            this.h = callable;
            this.i = j;
            this.j = j2;
            this.k = timeUnit;
            this.l = worker;
            this.m = new LinkedList();
        }

        void a() {
            synchronized (this) {
                this.m.clear();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public /* bridge */ /* synthetic */ boolean accept(Subscriber subscriber, Object obj) {
            return accept((Subscriber<? super Subscriber>) subscriber, (Subscriber) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean accept(Subscriber<? super U> subscriber, U u) {
            subscriber.onNext(u);
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.e = true;
            this.n.cancel();
            this.l.dispose();
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.m);
                this.m.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.d.offer((Collection) it.next());
            }
            this.f = true;
            if (enter()) {
                QueueDrainHelper.drainMaxLoop(this.d, this.c, false, this.l, this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f = true;
            this.l.dispose();
            a();
            this.c.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            synchronized (this) {
                Iterator<U> it = this.m.iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.n, subscription)) {
                this.n = subscription;
                try {
                    Collection collection = (Collection) ObjectHelper.requireNonNull(this.h.call(), "The supplied buffer is null");
                    this.m.add(collection);
                    this.c.onSubscribe(this);
                    subscription.request(Long.MAX_VALUE);
                    Scheduler.Worker worker = this.l;
                    long j = this.j;
                    worker.schedulePeriodically(this, j, j, this.k);
                    this.l.schedule(new RemoveFromBuffer(collection), this.i, this.k);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.l.dispose();
                    subscription.cancel();
                    EmptySubscription.error(th, this.c);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.e) {
                return;
            }
            try {
                Collection collection = (Collection) ObjectHelper.requireNonNull(this.h.call(), "The supplied buffer is null");
                synchronized (this) {
                    if (this.e) {
                        return;
                    }
                    this.m.add(collection);
                    this.l.schedule(new RemoveFromBuffer(collection), this.i, this.k);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                this.c.onError(th);
            }
        }
    }

    public FlowableBufferTimed(Flowable<T> flowable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable, int i, boolean z) {
        super(flowable);
        this.c = j;
        this.d = j2;
        this.e = timeUnit;
        this.f = scheduler;
        this.g = callable;
        this.h = i;
        this.i = z;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super U> subscriber) {
        if (this.c == this.d && this.h == Integer.MAX_VALUE) {
            this.b.subscribe((FlowableSubscriber) new BufferExactUnboundedSubscriber(new SerializedSubscriber(subscriber), this.g, this.c, this.e, this.f));
            return;
        }
        Scheduler.Worker createWorker = this.f.createWorker();
        long j = this.c;
        long j2 = this.d;
        Flowable<T> flowable = this.b;
        if (j == j2) {
            flowable.subscribe((FlowableSubscriber) new BufferExactBoundedSubscriber(new SerializedSubscriber(subscriber), this.g, this.c, this.e, this.h, this.i, createWorker));
        } else {
            flowable.subscribe((FlowableSubscriber) new BufferSkipBoundedSubscriber(new SerializedSubscriber(subscriber), this.g, this.c, this.d, this.e, createWorker));
        }
    }
}
