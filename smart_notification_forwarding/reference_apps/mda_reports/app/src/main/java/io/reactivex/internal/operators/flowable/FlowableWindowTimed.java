package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableWindowTimed<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final long c;
    final long d;
    final TimeUnit e;
    final Scheduler f;
    final long g;
    final int h;
    final boolean i;

    /* loaded from: classes2.dex */
    static final class WindowExactBoundedSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription {
        final long h;
        final TimeUnit i;
        final Scheduler j;
        final int k;
        final boolean l;
        final long m;
        final Scheduler.Worker n;
        long o;
        long p;
        Subscription q;
        UnicastProcessor<T> r;
        volatile boolean s;
        final SequentialDisposable t;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public static final class ConsumerIndexHolder implements Runnable {
            final long a;
            final WindowExactBoundedSubscriber<?> b;

            ConsumerIndexHolder(long j, WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber) {
                this.a = j;
                this.b = windowExactBoundedSubscriber;
            }

            @Override // java.lang.Runnable
            public void run() {
                WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber = this.b;
                if (((QueueDrainSubscriber) windowExactBoundedSubscriber).e) {
                    windowExactBoundedSubscriber.s = true;
                    windowExactBoundedSubscriber.dispose();
                } else {
                    ((QueueDrainSubscriber) windowExactBoundedSubscriber).d.offer(this);
                }
                if (windowExactBoundedSubscriber.enter()) {
                    windowExactBoundedSubscriber.a();
                }
            }
        }

        WindowExactBoundedSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler, int i, long j2, boolean z) {
            super(subscriber, new MpscLinkedQueue());
            this.t = new SequentialDisposable();
            this.h = j;
            this.i = timeUnit;
            this.j = scheduler;
            this.k = i;
            this.m = j2;
            this.l = z;
            this.n = z ? scheduler.createWorker() : null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x002d, code lost:
        
            r17.r = null;
            r1.clear();
            r1 = r17.g;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0034, code lost:
        
            if (r1 == null) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0036, code lost:
        
            ((io.reactivex.processors.UnicastProcessor) r3).onError(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
        
            dispose();
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
        
            ((io.reactivex.processors.UnicastProcessor) r3).onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
        
            if (r17.p == r7.a) goto L34;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void a() {
            /*
                Method dump skipped, instructions count: 285
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactBoundedSubscriber.a():void");
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.e = true;
        }

        public void dispose() {
            DisposableHelper.dispose(this.t);
            Scheduler.Worker worker = this.n;
            if (worker != null) {
                worker.dispose();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f = true;
            if (enter()) {
                a();
            }
            this.c.onComplete();
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.g = th;
            this.f = true;
            if (enter()) {
                a();
            }
            this.c.onError(th);
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.s) {
                return;
            }
            if (fastEnter()) {
                UnicastProcessor<T> unicastProcessor = this.r;
                unicastProcessor.onNext(t);
                long j = this.o + 1;
                if (j >= this.m) {
                    this.p++;
                    this.o = 0L;
                    unicastProcessor.onComplete();
                    long requested = requested();
                    if (requested == 0) {
                        this.r = null;
                        this.q.cancel();
                        this.c.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                        dispose();
                        return;
                    }
                    UnicastProcessor<T> create = UnicastProcessor.create(this.k);
                    this.r = create;
                    this.c.onNext(create);
                    if (requested != Long.MAX_VALUE) {
                        produced(1L);
                    }
                    if (this.l) {
                        this.t.get().dispose();
                        Scheduler.Worker worker = this.n;
                        ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.p, this);
                        long j2 = this.h;
                        this.t.replace(worker.schedulePeriodically(consumerIndexHolder, j2, j2, this.i));
                    }
                } else {
                    this.o = j;
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.d.offer(NotificationLite.next(t));
                if (!enter()) {
                    return;
                }
            }
            a();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Disposable schedulePeriodicallyDirect;
            if (SubscriptionHelper.validate(this.q, subscription)) {
                this.q = subscription;
                Subscriber<? super V> subscriber = this.c;
                subscriber.onSubscribe(this);
                if (this.e) {
                    return;
                }
                UnicastProcessor<T> create = UnicastProcessor.create(this.k);
                this.r = create;
                long requested = requested();
                if (requested == 0) {
                    this.e = true;
                    subscription.cancel();
                    subscriber.onError(new MissingBackpressureException("Could not deliver initial window due to lack of requests."));
                    return;
                }
                subscriber.onNext(create);
                if (requested != Long.MAX_VALUE) {
                    produced(1L);
                }
                ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.p, this);
                if (this.l) {
                    Scheduler.Worker worker = this.n;
                    long j = this.h;
                    schedulePeriodicallyDirect = worker.schedulePeriodically(consumerIndexHolder, j, j, this.i);
                } else {
                    Scheduler scheduler = this.j;
                    long j2 = this.h;
                    schedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(consumerIndexHolder, j2, j2, this.i);
                }
                if (this.t.replace(schedulePeriodicallyDirect)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }
    }

    /* loaded from: classes2.dex */
    static final class WindowExactUnboundedSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements FlowableSubscriber<T>, Subscription, Runnable {
        static final Object p = new Object();
        final long h;
        final TimeUnit i;
        final Scheduler j;
        final int k;
        Subscription l;
        UnicastProcessor<T> m;
        final SequentialDisposable n;
        volatile boolean o;

        WindowExactUnboundedSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
            super(subscriber, new MpscLinkedQueue());
            this.n = new SequentialDisposable();
            this.h = j;
            this.i = timeUnit;
            this.j = scheduler;
            this.k = i;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
        
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
        
            r10.m = null;
            r0.clear();
            dispose();
            r0 = r10.g;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        
            if (r0 == null) goto L11;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [io.reactivex.processors.UnicastProcessor<T>] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void a() {
            /*
                r10 = this;
                io.reactivex.internal.fuseable.SimplePlainQueue<U> r0 = r10.d
                org.reactivestreams.Subscriber<? super V> r1 = r10.c
                io.reactivex.processors.UnicastProcessor<T> r2 = r10.m
                r3 = 1
            L7:
                boolean r4 = r10.o
                boolean r5 = r10.f
                java.lang.Object r6 = r0.poll()
                r7 = 0
                if (r5 == 0) goto L2c
                if (r6 == 0) goto L18
                java.lang.Object r5 = io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactUnboundedSubscriber.p
                if (r6 != r5) goto L2c
            L18:
                r10.m = r7
                r0.clear()
                r10.dispose()
                java.lang.Throwable r0 = r10.g
                if (r0 == 0) goto L28
                r2.onError(r0)
                goto L2b
            L28:
                r2.onComplete()
            L2b:
                return
            L2c:
                if (r6 != 0) goto L36
                int r3 = -r3
                int r3 = r10.leave(r3)
                if (r3 != 0) goto L7
                return
            L36:
                java.lang.Object r5 = io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactUnboundedSubscriber.p
                if (r6 != r5) goto L83
                r2.onComplete()
                if (r4 != 0) goto L7d
                int r2 = r10.k
                io.reactivex.processors.UnicastProcessor r2 = io.reactivex.processors.UnicastProcessor.create(r2)
                r10.m = r2
                long r4 = r10.requested()
                r8 = 0
                int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
                if (r6 == 0) goto L63
                r1.onNext(r2)
                r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r8 == 0) goto L7
                r4 = 1
                r10.produced(r4)
                goto L7
            L63:
                r10.m = r7
                io.reactivex.internal.fuseable.SimplePlainQueue<U> r0 = r10.d
                r0.clear()
                org.reactivestreams.Subscription r0 = r10.l
                r0.cancel()
                r10.dispose()
                io.reactivex.exceptions.MissingBackpressureException r0 = new io.reactivex.exceptions.MissingBackpressureException
                java.lang.String r2 = "Could not deliver first window due to lack of requests."
                r0.<init>(r2)
                r1.onError(r0)
                return
            L7d:
                org.reactivestreams.Subscription r4 = r10.l
                r4.cancel()
                goto L7
            L83:
                java.lang.Object r4 = io.reactivex.internal.util.NotificationLite.getValue(r6)
                r2.onNext(r4)
                goto L7
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactUnboundedSubscriber.a():void");
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.e = true;
        }

        public void dispose() {
            DisposableHelper.dispose(this.n);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f = true;
            if (enter()) {
                a();
            }
            this.c.onComplete();
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.g = th;
            this.f = true;
            if (enter()) {
                a();
            }
            this.c.onError(th);
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.o) {
                return;
            }
            if (fastEnter()) {
                this.m.onNext(t);
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.d.offer(NotificationLite.next(t));
                if (!enter()) {
                    return;
                }
            }
            a();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.l, subscription)) {
                this.l = subscription;
                this.m = UnicastProcessor.create(this.k);
                Subscriber<? super V> subscriber = this.c;
                subscriber.onSubscribe(this);
                long requested = requested();
                if (requested == 0) {
                    this.e = true;
                    subscription.cancel();
                    subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                    return;
                }
                subscriber.onNext(this.m);
                if (requested != Long.MAX_VALUE) {
                    produced(1L);
                }
                if (this.e) {
                    return;
                }
                SequentialDisposable sequentialDisposable = this.n;
                Scheduler scheduler = this.j;
                long j = this.h;
                if (sequentialDisposable.replace(scheduler.schedulePeriodicallyDirect(this, j, j, this.i))) {
                    subscription.request(Long.MAX_VALUE);
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
                this.o = true;
                dispose();
            }
            this.d.offer(p);
            if (enter()) {
                a();
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class WindowSkipSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription, Runnable {
        final long h;
        final long i;
        final TimeUnit j;
        final Scheduler.Worker k;
        final int l;
        final List<UnicastProcessor<T>> m;
        Subscription n;
        volatile boolean o;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public final class Completion implements Runnable {
            private final UnicastProcessor<T> processor;

            Completion(UnicastProcessor<T> unicastProcessor) {
                this.processor = unicastProcessor;
            }

            @Override // java.lang.Runnable
            public void run() {
                WindowSkipSubscriber.this.a(this.processor);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public static final class SubjectWork<T> {
            final UnicastProcessor<T> a;
            final boolean b;

            SubjectWork(UnicastProcessor<T> unicastProcessor, boolean z) {
                this.a = unicastProcessor;
                this.b = z;
            }
        }

        WindowSkipSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker, int i) {
            super(subscriber, new MpscLinkedQueue());
            this.h = j;
            this.i = j2;
            this.j = timeUnit;
            this.k = worker;
            this.l = i;
            this.m = new LinkedList();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            SimpleQueue simpleQueue = this.d;
            Subscriber<? super V> subscriber = this.c;
            List<UnicastProcessor<T>> list = this.m;
            int i = 1;
            while (!this.o) {
                boolean z = this.f;
                Object poll = simpleQueue.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof SubjectWork;
                if (z && (z2 || z3)) {
                    simpleQueue.clear();
                    Throwable th = this.g;
                    if (th != null) {
                        Iterator<UnicastProcessor<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        Iterator<UnicastProcessor<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    list.clear();
                    dispose();
                    return;
                }
                if (z2) {
                    i = leave(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (z3) {
                    SubjectWork subjectWork = (SubjectWork) poll;
                    if (!subjectWork.b) {
                        list.remove(subjectWork.a);
                        subjectWork.a.onComplete();
                        if (list.isEmpty() && this.e) {
                            this.o = true;
                        }
                    } else if (!this.e) {
                        long requested = requested();
                        if (requested != 0) {
                            UnicastProcessor<T> create = UnicastProcessor.create(this.l);
                            list.add(create);
                            subscriber.onNext(create);
                            if (requested != Long.MAX_VALUE) {
                                produced(1L);
                            }
                            this.k.schedule(new Completion(create), this.h, this.j);
                        } else {
                            subscriber.onError(new MissingBackpressureException("Can't emit window due to lack of requests"));
                        }
                    }
                } else {
                    Iterator<UnicastProcessor<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(poll);
                    }
                }
            }
            this.n.cancel();
            dispose();
            simpleQueue.clear();
            list.clear();
        }

        void a(UnicastProcessor<T> unicastProcessor) {
            this.d.offer(new SubjectWork(unicastProcessor, false));
            if (enter()) {
                a();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.e = true;
        }

        public void dispose() {
            this.k.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f = true;
            if (enter()) {
                a();
            }
            this.c.onComplete();
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.g = th;
            this.f = true;
            if (enter()) {
                a();
            }
            this.c.onError(th);
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (fastEnter()) {
                Iterator<UnicastProcessor<T>> it = this.m.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.d.offer(t);
                if (!enter()) {
                    return;
                }
            }
            a();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.n, subscription)) {
                this.n = subscription;
                this.c.onSubscribe(this);
                if (this.e) {
                    return;
                }
                long requested = requested();
                if (requested == 0) {
                    subscription.cancel();
                    this.c.onError(new MissingBackpressureException("Could not emit the first window due to lack of requests"));
                    return;
                }
                UnicastProcessor<T> create = UnicastProcessor.create(this.l);
                this.m.add(create);
                this.c.onNext(create);
                if (requested != Long.MAX_VALUE) {
                    produced(1L);
                }
                this.k.schedule(new Completion(create), this.h, this.j);
                Scheduler.Worker worker = this.k;
                long j = this.i;
                worker.schedulePeriodically(this, j, j, this.j);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }

        @Override // java.lang.Runnable
        public void run() {
            SubjectWork subjectWork = new SubjectWork(UnicastProcessor.create(this.l), true);
            if (!this.e) {
                this.d.offer(subjectWork);
            }
            if (enter()) {
                a();
            }
        }
    }

    public FlowableWindowTimed(Flowable<T> flowable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, long j3, int i, boolean z) {
        super(flowable);
        this.c = j;
        this.d = j2;
        this.e = timeUnit;
        this.f = scheduler;
        this.g = j3;
        this.h = i;
        this.i = z;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        long j = this.c;
        long j2 = this.d;
        if (j != j2) {
            this.b.subscribe((FlowableSubscriber) new WindowSkipSubscriber(serializedSubscriber, j, j2, this.e, this.f.createWorker(), this.h));
            return;
        }
        long j3 = this.g;
        if (j3 == Long.MAX_VALUE) {
            this.b.subscribe((FlowableSubscriber) new WindowExactUnboundedSubscriber(serializedSubscriber, j, this.e, this.f, this.h));
        } else {
            this.b.subscribe((FlowableSubscriber) new WindowExactBoundedSubscriber(serializedSubscriber, j, this.e, this.f, this.h, j3, this.i));
        }
    }
}
