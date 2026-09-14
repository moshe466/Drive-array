package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableObserveOn<T> extends AbstractFlowableWithUpstream<T, T> {
    final Scheduler c;
    final boolean d;
    final int e;

    /* loaded from: classes2.dex */
    static abstract class BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T>, Runnable {
        private static final long serialVersionUID = -8241002408341274697L;
        final Scheduler.Worker a;
        final boolean b;
        final int c;
        final int d;
        final AtomicLong e = new AtomicLong();
        Subscription f;
        SimpleQueue<T> g;
        volatile boolean h;
        volatile boolean i;
        Throwable j;
        int k;
        long l;
        boolean m;

        BaseObserveOnSubscriber(Scheduler.Worker worker, boolean z, int i) {
            this.a = worker;
            this.b = z;
            this.c = i;
            this.d = i - (i >> 2);
        }

        abstract void a();

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
        
            if (r3 != null) goto L18;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        final boolean a(boolean r3, boolean r4, org.reactivestreams.Subscriber<?> r5) {
            /*
                r2 = this;
                boolean r0 = r2.h
                r1 = 1
                if (r0 == 0) goto L9
                r2.clear()
                return r1
            L9:
                if (r3 == 0) goto L2d
                boolean r3 = r2.b
                if (r3 == 0) goto L1c
                if (r4 == 0) goto L2d
                java.lang.Throwable r3 = r2.j
                if (r3 == 0) goto L29
                goto L23
            L16:
                io.reactivex.Scheduler$Worker r3 = r2.a
                r3.dispose()
                return r1
            L1c:
                java.lang.Throwable r3 = r2.j
                if (r3 == 0) goto L27
                r2.clear()
            L23:
                r5.onError(r3)
                goto L16
            L27:
                if (r4 == 0) goto L2d
            L29:
                r5.onComplete()
                goto L16
            L2d:
                r3 = 0
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber.a(boolean, boolean, org.reactivestreams.Subscriber):boolean");
        }

        abstract void b();

        abstract void c();

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.h) {
                return;
            }
            this.h = true;
            this.f.cancel();
            this.a.dispose();
            if (getAndIncrement() == 0) {
                this.g.clear();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.g.clear();
        }

        final void d() {
            if (getAndIncrement() != 0) {
                return;
            }
            this.a.schedule(this);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.g.isEmpty();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.i) {
                return;
            }
            this.i = true;
            d();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.i) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.j = th;
            this.i = true;
            d();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.i) {
                return;
            }
            if (this.k == 2) {
                d();
                return;
            }
            if (!this.g.offer(t)) {
                this.f.cancel();
                this.j = new MissingBackpressureException("Queue is full?!");
                this.i = true;
            }
            d();
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.e, j);
                d();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.m = true;
            return 2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.m) {
                b();
            } else if (this.k == 1) {
                c();
            } else {
                a();
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class ObserveOnConditionalSubscriber<T> extends BaseObserveOnSubscriber<T> {
        private static final long serialVersionUID = 644624475404284533L;
        final ConditionalSubscriber<? super T> n;
        long o;

        ObserveOnConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Scheduler.Worker worker, boolean z, int i) {
            super(worker, z, i);
            this.n = conditionalSubscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void a() {
            ConditionalSubscriber<? super T> conditionalSubscriber = this.n;
            SimpleQueue<T> simpleQueue = this.g;
            long j = this.l;
            long j2 = this.o;
            int i = 1;
            while (true) {
                long j3 = this.e.get();
                while (j != j3) {
                    boolean z = this.i;
                    try {
                        T poll = simpleQueue.poll();
                        boolean z2 = poll == null;
                        if (a(z, z2, conditionalSubscriber)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        if (conditionalSubscriber.tryOnNext(poll)) {
                            j++;
                        }
                        j2++;
                        if (j2 == this.d) {
                            this.f.request(j2);
                            j2 = 0;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.f.cancel();
                        simpleQueue.clear();
                        conditionalSubscriber.onError(th);
                        this.a.dispose();
                        return;
                    }
                }
                if (j == j3 && a(this.i, simpleQueue.isEmpty(), conditionalSubscriber)) {
                    return;
                }
                int i2 = get();
                if (i == i2) {
                    this.l = j;
                    this.o = j2;
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    i = i2;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void b() {
            int i = 1;
            while (!this.h) {
                boolean z = this.i;
                this.n.onNext(null);
                if (z) {
                    Throwable th = this.j;
                    if (th != null) {
                        this.n.onError(th);
                    } else {
                        this.n.onComplete();
                    }
                    this.a.dispose();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x001c, code lost:
        
            r0.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x003e, code lost:
        
            if (r9.h == false) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0045, code lost:
        
            if (r1.isEmpty() == false) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0048, code lost:
        
            r5 = get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x004c, code lost:
        
            if (r4 != r5) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0058, code lost:
        
            r4 = r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x004e, code lost:
        
            r9.l = r2;
            r4 = addAndGet(-r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0055, code lost:
        
            if (r4 != 0) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0057, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0040, code lost:
        
            return;
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void c() {
            /*
                r9 = this;
                io.reactivex.internal.fuseable.ConditionalSubscriber<? super T> r0 = r9.n
                io.reactivex.internal.fuseable.SimpleQueue<T> r1 = r9.g
                long r2 = r9.l
                r4 = 1
            L7:
                java.util.concurrent.atomic.AtomicLong r5 = r9.e
                long r5 = r5.get()
            Ld:
                int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r7 == 0) goto L3c
                java.lang.Object r7 = r1.poll()     // Catch: java.lang.Throwable -> L2f
                boolean r8 = r9.h
                if (r8 == 0) goto L1a
                return
            L1a:
                if (r7 != 0) goto L25
            L1c:
                r0.onComplete()
            L1f:
                io.reactivex.Scheduler$Worker r0 = r9.a
                r0.dispose()
                return
            L25:
                boolean r7 = r0.tryOnNext(r7)
                if (r7 == 0) goto Ld
                r7 = 1
                long r2 = r2 + r7
                goto Ld
            L2f:
                r1 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r1)
                org.reactivestreams.Subscription r2 = r9.f
                r2.cancel()
                r0.onError(r1)
                goto L1f
            L3c:
                boolean r5 = r9.h
                if (r5 == 0) goto L41
                return
            L41:
                boolean r5 = r1.isEmpty()
                if (r5 == 0) goto L48
                goto L1c
            L48:
                int r5 = r9.get()
                if (r4 != r5) goto L58
                r9.l = r2
                int r4 = -r4
                int r4 = r9.addAndGet(r4)
                if (r4 != 0) goto L7
                return
            L58:
                r4 = r5
                goto L7
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableObserveOn.ObserveOnConditionalSubscriber.c():void");
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.k = 1;
                        this.g = queueSubscription;
                        this.i = true;
                        this.n.onSubscribe(this);
                        return;
                    }
                    if (requestFusion == 2) {
                        this.k = 2;
                        this.g = queueSubscription;
                        this.n.onSubscribe(this);
                        subscription.request(this.c);
                        return;
                    }
                }
                this.g = new SpscArrayQueue(this.c);
                this.n.onSubscribe(this);
                subscription.request(this.c);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            T poll = this.g.poll();
            if (poll != null && this.k != 1) {
                long j = this.o + 1;
                if (j == this.d) {
                    this.o = 0L;
                    this.f.request(j);
                } else {
                    this.o = j;
                }
            }
            return poll;
        }
    }

    /* loaded from: classes2.dex */
    static final class ObserveOnSubscriber<T> extends BaseObserveOnSubscriber<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -4547113800637756442L;
        final Subscriber<? super T> n;

        ObserveOnSubscriber(Subscriber<? super T> subscriber, Scheduler.Worker worker, boolean z, int i) {
            super(worker, z, i);
            this.n = subscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void a() {
            Subscriber<? super T> subscriber = this.n;
            SimpleQueue<T> simpleQueue = this.g;
            long j = this.l;
            int i = 1;
            while (true) {
                long j2 = this.e.get();
                while (j != j2) {
                    boolean z = this.i;
                    try {
                        T poll = simpleQueue.poll();
                        boolean z2 = poll == null;
                        if (a(z, z2, subscriber)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        subscriber.onNext(poll);
                        j++;
                        if (j == this.d) {
                            if (j2 != Long.MAX_VALUE) {
                                j2 = this.e.addAndGet(-j);
                            }
                            this.f.request(j);
                            j = 0;
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.f.cancel();
                        simpleQueue.clear();
                        subscriber.onError(th);
                        this.a.dispose();
                        return;
                    }
                }
                if (j == j2 && a(this.i, simpleQueue.isEmpty(), subscriber)) {
                    return;
                }
                int i2 = get();
                if (i == i2) {
                    this.l = j;
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    i = i2;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void b() {
            int i = 1;
            while (!this.h) {
                boolean z = this.i;
                this.n.onNext(null);
                if (z) {
                    Throwable th = this.j;
                    if (th != null) {
                        this.n.onError(th);
                    } else {
                        this.n.onComplete();
                    }
                    this.a.dispose();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
        
            r0.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
        
            if (r9.h == false) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0042, code lost:
        
            if (r1.isEmpty() == false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0045, code lost:
        
            r5 = get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
        
            if (r4 != r5) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
        
            r4 = r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x004b, code lost:
        
            r9.l = r2;
            r4 = addAndGet(-r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0052, code lost:
        
            if (r4 != 0) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0054, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x003d, code lost:
        
            return;
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void c() {
            /*
                r9 = this;
                org.reactivestreams.Subscriber<? super T> r0 = r9.n
                io.reactivex.internal.fuseable.SimpleQueue<T> r1 = r9.g
                long r2 = r9.l
                r4 = 1
            L7:
                java.util.concurrent.atomic.AtomicLong r5 = r9.e
                long r5 = r5.get()
            Ld:
                int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r7 == 0) goto L39
                java.lang.Object r7 = r1.poll()     // Catch: java.lang.Throwable -> L2c
                boolean r8 = r9.h
                if (r8 == 0) goto L1a
                return
            L1a:
                if (r7 != 0) goto L25
            L1c:
                r0.onComplete()
            L1f:
                io.reactivex.Scheduler$Worker r0 = r9.a
                r0.dispose()
                return
            L25:
                r0.onNext(r7)
                r7 = 1
                long r2 = r2 + r7
                goto Ld
            L2c:
                r1 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r1)
                org.reactivestreams.Subscription r2 = r9.f
                r2.cancel()
                r0.onError(r1)
                goto L1f
            L39:
                boolean r5 = r9.h
                if (r5 == 0) goto L3e
                return
            L3e:
                boolean r5 = r1.isEmpty()
                if (r5 == 0) goto L45
                goto L1c
            L45:
                int r5 = r9.get()
                if (r4 != r5) goto L55
                r9.l = r2
                int r4 = -r4
                int r4 = r9.addAndGet(r4)
                if (r4 != 0) goto L7
                return
            L55:
                r4 = r5
                goto L7
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableObserveOn.ObserveOnSubscriber.c():void");
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.k = 1;
                        this.g = queueSubscription;
                        this.i = true;
                        this.n.onSubscribe(this);
                        return;
                    }
                    if (requestFusion == 2) {
                        this.k = 2;
                        this.g = queueSubscription;
                        this.n.onSubscribe(this);
                        subscription.request(this.c);
                        return;
                    }
                }
                this.g = new SpscArrayQueue(this.c);
                this.n.onSubscribe(this);
                subscription.request(this.c);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            T poll = this.g.poll();
            if (poll != null && this.k != 1) {
                long j = this.l + 1;
                if (j == this.d) {
                    this.l = 0L;
                    this.f.request(j);
                } else {
                    this.l = j;
                }
            }
            return poll;
        }
    }

    public FlowableObserveOn(Flowable<T> flowable, Scheduler scheduler, boolean z, int i) {
        super(flowable);
        this.c = scheduler;
        this.d = z;
        this.e = i;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        Flowable<T> flowable;
        FlowableSubscriber<? super T> observeOnSubscriber;
        Scheduler.Worker createWorker = this.c.createWorker();
        if (subscriber instanceof ConditionalSubscriber) {
            flowable = this.b;
            observeOnSubscriber = new ObserveOnConditionalSubscriber<>((ConditionalSubscriber) subscriber, createWorker, this.d, this.e);
        } else {
            flowable = this.b;
            observeOnSubscriber = new ObserveOnSubscriber<>(subscriber, createWorker, this.d, this.e);
        }
        flowable.subscribe((FlowableSubscriber) observeOnSubscriber);
    }
}
