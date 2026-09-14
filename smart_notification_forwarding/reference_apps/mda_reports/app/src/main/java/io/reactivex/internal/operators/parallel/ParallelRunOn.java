package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes3.dex */
public final class ParallelRunOn<T> extends ParallelFlowable<T> {
    final ParallelFlowable<? extends T> a;
    final Scheduler b;
    final int c;

    /* loaded from: classes3.dex */
    static abstract class BaseRunOnSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 9222303586456402150L;
        final int a;
        final int b;
        final SpscArrayQueue<T> c;
        final Scheduler.Worker d;
        Subscription e;
        volatile boolean f;
        Throwable g;
        final AtomicLong h = new AtomicLong();
        volatile boolean i;
        int j;

        BaseRunOnSubscriber(int i, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            this.a = i;
            this.c = spscArrayQueue;
            this.b = i - (i >> 2);
            this.d = worker;
        }

        final void a() {
            if (getAndIncrement() == 0) {
                this.d.schedule(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.i) {
                return;
            }
            this.i = true;
            this.e.cancel();
            this.d.dispose();
            if (getAndIncrement() == 0) {
                this.c.clear();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.f) {
                return;
            }
            this.f = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.f) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.g = th;
            this.f = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.f) {
                return;
            }
            if (this.c.offer(t)) {
                a();
            } else {
                this.e.cancel();
                onError(new MissingBackpressureException("Queue is full?!"));
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.h, j);
                a();
            }
        }
    }

    /* loaded from: classes3.dex */
    final class MultiWorkerCallback implements SchedulerMultiWorkerSupport.WorkerCallback {
        final Subscriber<? super T>[] a;
        final Subscriber<T>[] b;

        MultiWorkerCallback(Subscriber<? super T>[] subscriberArr, Subscriber<T>[] subscriberArr2) {
            this.a = subscriberArr;
            this.b = subscriberArr2;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport.WorkerCallback
        public void onWorker(int i, Scheduler.Worker worker) {
            ParallelRunOn.this.a(i, this.a, this.b, worker);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class RunOnConditionalSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final ConditionalSubscriber<? super T> k;

        RunOnConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, int i, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            super(i, spscArrayQueue, worker);
            this.k = conditionalSubscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                this.e = subscription;
                this.k.onSubscribe(this);
                subscription.request(this.a);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
        
            r3.onComplete();
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r17 = this;
                r0 = r17
                int r1 = r0.j
                io.reactivex.internal.queue.SpscArrayQueue<T> r2 = r0.c
                io.reactivex.internal.fuseable.ConditionalSubscriber<? super T> r3 = r0.k
                int r4 = r0.b
                r6 = 1
            Lb:
                java.util.concurrent.atomic.AtomicLong r7 = r0.h
                long r7 = r7.get()
                r9 = 0
                r11 = r9
            L14:
                int r13 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
                if (r13 == 0) goto L67
                boolean r13 = r0.i
                if (r13 == 0) goto L20
                r2.clear()
                return
            L20:
                boolean r13 = r0.f
                if (r13 == 0) goto L34
                java.lang.Throwable r14 = r0.g
                if (r14 == 0) goto L34
                r2.clear()
                r3.onError(r14)
            L2e:
                io.reactivex.Scheduler$Worker r1 = r0.d
                r1.dispose()
                return
            L34:
                java.lang.Object r14 = r2.poll()
                r15 = 0
                if (r14 != 0) goto L3e
                r16 = 1
                goto L40
            L3e:
                r16 = 0
            L40:
                if (r13 == 0) goto L48
                if (r16 == 0) goto L48
            L44:
                r3.onComplete()
                goto L2e
            L48:
                if (r16 == 0) goto L4b
                goto L67
            L4b:
                boolean r13 = r3.tryOnNext(r14)
                if (r13 == 0) goto L54
                r13 = 1
                long r11 = r11 + r13
            L54:
                int r1 = r1 + 1
                if (r1 != r4) goto L62
                org.reactivestreams.Subscription r13 = r0.e
                r16 = r6
                long r5 = (long) r1
                r13.request(r5)
                r1 = 0
                goto L64
            L62:
                r16 = r6
            L64:
                r6 = r16
                goto L14
            L67:
                r16 = r6
                int r5 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
                if (r5 != 0) goto L8b
                boolean r5 = r0.i
                if (r5 == 0) goto L75
                r2.clear()
                return
            L75:
                boolean r5 = r0.f
                if (r5 == 0) goto L8b
                java.lang.Throwable r5 = r0.g
                if (r5 == 0) goto L84
                r2.clear()
                r3.onError(r5)
                goto L2e
            L84:
                boolean r5 = r2.isEmpty()
                if (r5 == 0) goto L8b
                goto L44
            L8b:
                int r5 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
                if (r5 == 0) goto L9e
                r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r9 == 0) goto L9e
                java.util.concurrent.atomic.AtomicLong r5 = r0.h
                long r6 = -r11
                r5.addAndGet(r6)
            L9e:
                int r5 = r17.get()
                r6 = r16
                if (r5 != r6) goto Lb0
                r0.j = r1
                int r5 = -r6
                int r5 = r0.addAndGet(r5)
                if (r5 != 0) goto Lb0
                return
            Lb0:
                r6 = r5
                goto Lb
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelRunOn.RunOnConditionalSubscriber.run():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class RunOnSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final Subscriber<? super T> k;

        RunOnSubscriber(Subscriber<? super T> subscriber, int i, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
            super(i, spscArrayQueue, worker);
            this.k = subscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.e, subscription)) {
                this.e = subscription;
                this.k.onSubscribe(this);
                subscription.request(this.a);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
        
            r3.onComplete();
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r17 = this;
                r0 = r17
                int r1 = r0.j
                io.reactivex.internal.queue.SpscArrayQueue<T> r2 = r0.c
                org.reactivestreams.Subscriber<? super T> r3 = r0.k
                int r4 = r0.b
                r6 = 1
            Lb:
                java.util.concurrent.atomic.AtomicLong r7 = r0.h
                long r7 = r7.get()
                r9 = 0
                r11 = r9
            L14:
                int r13 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
                if (r13 == 0) goto L64
                boolean r13 = r0.i
                if (r13 == 0) goto L20
                r2.clear()
                return
            L20:
                boolean r13 = r0.f
                if (r13 == 0) goto L34
                java.lang.Throwable r14 = r0.g
                if (r14 == 0) goto L34
                r2.clear()
                r3.onError(r14)
            L2e:
                io.reactivex.Scheduler$Worker r1 = r0.d
                r1.dispose()
                return
            L34:
                java.lang.Object r14 = r2.poll()
                r15 = 0
                if (r14 != 0) goto L3e
                r16 = 1
                goto L40
            L3e:
                r16 = 0
            L40:
                if (r13 == 0) goto L48
                if (r16 == 0) goto L48
            L44:
                r3.onComplete()
                goto L2e
            L48:
                if (r16 == 0) goto L4b
                goto L64
            L4b:
                r3.onNext(r14)
                r13 = 1
                long r11 = r11 + r13
                int r1 = r1 + 1
                if (r1 != r4) goto L5f
                org.reactivestreams.Subscription r13 = r0.e
                r16 = r6
                long r5 = (long) r1
                r13.request(r5)
                r1 = 0
                goto L61
            L5f:
                r16 = r6
            L61:
                r6 = r16
                goto L14
            L64:
                r16 = r6
                int r5 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
                if (r5 != 0) goto L88
                boolean r5 = r0.i
                if (r5 == 0) goto L72
                r2.clear()
                return
            L72:
                boolean r5 = r0.f
                if (r5 == 0) goto L88
                java.lang.Throwable r5 = r0.g
                if (r5 == 0) goto L81
                r2.clear()
                r3.onError(r5)
                goto L2e
            L81:
                boolean r5 = r2.isEmpty()
                if (r5 == 0) goto L88
                goto L44
            L88:
                int r5 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
                if (r5 == 0) goto L9b
                r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r9 == 0) goto L9b
                java.util.concurrent.atomic.AtomicLong r5 = r0.h
                long r6 = -r11
                r5.addAndGet(r6)
            L9b:
                int r5 = r17.get()
                r6 = r16
                if (r5 != r6) goto Lad
                r0.j = r1
                int r5 = -r6
                int r5 = r0.addAndGet(r5)
                if (r5 != 0) goto Lad
                return
            Lad:
                r6 = r5
                goto Lb
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelRunOn.RunOnSubscriber.run():void");
        }
    }

    public ParallelRunOn(ParallelFlowable<? extends T> parallelFlowable, Scheduler scheduler, int i) {
        this.a = parallelFlowable;
        this.b = scheduler;
        this.c = i;
    }

    void a(int i, Subscriber<? super T>[] subscriberArr, Subscriber<T>[] subscriberArr2, Scheduler.Worker worker) {
        Subscriber<? super T> subscriber = subscriberArr[i];
        SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.c);
        if (subscriber instanceof ConditionalSubscriber) {
            subscriberArr2[i] = new RunOnConditionalSubscriber((ConditionalSubscriber) subscriber, this.c, spscArrayQueue, worker);
        } else {
            subscriberArr2[i] = new RunOnSubscriber(subscriber, this.c, spscArrayQueue, worker);
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int parallelism() {
        return this.a.parallelism();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (a(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber<T>[] subscriberArr2 = new Subscriber[length];
            Object obj = this.b;
            if (obj instanceof SchedulerMultiWorkerSupport) {
                ((SchedulerMultiWorkerSupport) obj).createWorkers(length, new MultiWorkerCallback(subscriberArr, subscriberArr2));
            } else {
                for (int i = 0; i < length; i++) {
                    a(i, subscriberArr, subscriberArr2, this.b.createWorker());
                }
            }
            this.a.subscribe(subscriberArr2);
        }
    }
}
