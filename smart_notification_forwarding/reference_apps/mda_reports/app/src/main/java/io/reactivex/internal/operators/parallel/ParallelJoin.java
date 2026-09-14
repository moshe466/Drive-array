package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes3.dex */
public final class ParallelJoin<T> extends Flowable<T> {
    final ParallelFlowable<? extends T> b;
    final int c;
    final boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class JoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 8410034718427740355L;
        final JoinSubscriptionBase<T> a;
        final int b;
        final int c;
        long d;
        volatile SimplePlainQueue<T> e;

        JoinInnerSubscriber(JoinSubscriptionBase<T> joinSubscriptionBase, int i) {
            this.a = joinSubscriptionBase;
            this.b = i;
            this.c = i - (i >> 2);
        }

        SimplePlainQueue<T> a() {
            SimplePlainQueue<T> simplePlainQueue = this.e;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.b);
            this.e = spscArrayQueue;
            return spscArrayQueue;
        }

        public boolean cancel() {
            return SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.a.onNext(this, t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, this.b);
        }

        public void request(long j) {
            long j2 = this.d + j;
            if (j2 < this.c) {
                this.d = j2;
            } else {
                this.d = 0L;
                get().request(j2);
            }
        }

        public void requestOne() {
            long j = this.d + 1;
            if (j != this.c) {
                this.d = j;
            } else {
                this.d = 0L;
                get().request(j);
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class JoinSubscription<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = 6312374661811000451L;

        JoinSubscription(Subscriber<? super T> subscriber, int i, int i2) {
            super(subscriber, i, i2);
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            d();
        }

        /* JADX WARN: Code restructure failed: missing block: B:78:0x005f, code lost:
        
            if (r13 == false) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x0061, code lost:
        
            if (r11 == false) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0063, code lost:
        
            r3.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0066, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x0067, code lost:
        
            if (r11 == false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x0069, code lost:
        
            r10 = r14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void d() {
            /*
                Method dump skipped, instructions count: 216
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscription.d():void");
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onComplete() {
            this.f.decrementAndGet();
            c();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onError(Throwable th) {
            if (this.c.compareAndSet(null, th)) {
                a();
                c();
            } else if (th != this.c.get()) {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.d.get() != 0) {
                    this.a.onNext(t);
                    if (this.d.get() != Long.MAX_VALUE) {
                        this.d.decrementAndGet();
                    }
                    joinInnerSubscriber.request(1L);
                } else if (!joinInnerSubscriber.a().offer(t)) {
                    a();
                    MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Queue full?!");
                    if (this.c.compareAndSet(null, missingBackpressureException)) {
                        this.a.onError(missingBackpressureException);
                        return;
                    } else {
                        RxJavaPlugins.onError(missingBackpressureException);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!joinInnerSubscriber.a().offer(t)) {
                a();
                onError(new MissingBackpressureException("Queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static abstract class JoinSubscriptionBase<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3100232009247827843L;
        final Subscriber<? super T> a;
        final JoinInnerSubscriber<T>[] b;
        volatile boolean e;
        final AtomicThrowable c = new AtomicThrowable();
        final AtomicLong d = new AtomicLong();
        final AtomicInteger f = new AtomicInteger();

        JoinSubscriptionBase(Subscriber<? super T> subscriber, int i, int i2) {
            this.a = subscriber;
            JoinInnerSubscriber<T>[] joinInnerSubscriberArr = new JoinInnerSubscriber[i];
            for (int i3 = 0; i3 < i; i3++) {
                joinInnerSubscriberArr[i3] = new JoinInnerSubscriber<>(this, i2);
            }
            this.b = joinInnerSubscriberArr;
            this.f.lazySet(i);
        }

        void a() {
            int i = 0;
            while (true) {
                JoinInnerSubscriber<T>[] joinInnerSubscriberArr = this.b;
                if (i >= joinInnerSubscriberArr.length) {
                    return;
                }
                joinInnerSubscriberArr[i].cancel();
                i++;
            }
        }

        void b() {
            int i = 0;
            while (true) {
                JoinInnerSubscriber<T>[] joinInnerSubscriberArr = this.b;
                if (i >= joinInnerSubscriberArr.length) {
                    return;
                }
                joinInnerSubscriberArr[i].e = null;
                i++;
            }
        }

        abstract void c();

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.e) {
                return;
            }
            this.e = true;
            a();
            if (getAndIncrement() == 0) {
                b();
            }
        }

        abstract void onComplete();

        abstract void onError(Throwable th);

        abstract void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t);

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.d, j);
                c();
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class JoinSubscriptionDelayError<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = -5737965195918321883L;

        JoinSubscriptionDelayError(Subscriber<? super T> subscriber, int i, int i2) {
            super(subscriber, i, i2);
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            d();
        }

        /* JADX WARN: Code restructure failed: missing block: B:74:0x004d, code lost:
        
            if (r13 == false) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x004f, code lost:
        
            if (r11 == false) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x0059, code lost:
        
            if (r17.c.get() == null) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x005b, code lost:
        
            r3.onError(r17.c.terminate());
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x0065, code lost:
        
            r3.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x0068, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x0069, code lost:
        
            if (r11 == false) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x006b, code lost:
        
            r10 = r14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void d() {
            /*
                Method dump skipped, instructions count: 221
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionDelayError.d():void");
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void onComplete() {
            this.f.decrementAndGet();
            c();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void onError(Throwable th) {
            this.c.addThrowable(th);
            this.f.decrementAndGet();
            c();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void onNext(JoinInnerSubscriber<T> joinInnerSubscriber, T t) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.d.get() != 0) {
                    this.a.onNext(t);
                    if (this.d.get() != Long.MAX_VALUE) {
                        this.d.decrementAndGet();
                    }
                    joinInnerSubscriber.request(1L);
                } else if (!joinInnerSubscriber.a().offer(t)) {
                    joinInnerSubscriber.cancel();
                    this.c.addThrowable(new MissingBackpressureException("Queue full?!"));
                    this.f.decrementAndGet();
                    d();
                    return;
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                if (!joinInnerSubscriber.a().offer(t) && joinInnerSubscriber.cancel()) {
                    this.c.addThrowable(new MissingBackpressureException("Queue full?!"));
                    this.f.decrementAndGet();
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            d();
        }
    }

    public ParallelJoin(ParallelFlowable<? extends T> parallelFlowable, int i, boolean z) {
        this.b = parallelFlowable;
        this.c = i;
        this.d = z;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        JoinSubscriptionBase joinSubscriptionDelayError = this.d ? new JoinSubscriptionDelayError(subscriber, this.b.parallelism(), this.c) : new JoinSubscription(subscriber, this.b.parallelism(), this.c);
        subscriber.onSubscribe(joinSubscriptionDelayError);
        this.b.subscribe(joinSubscriptionDelayError.b);
    }
}
