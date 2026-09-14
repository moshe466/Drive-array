package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableSkipLastTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final long c;
    final TimeUnit d;
    final Scheduler e;
    final int f;
    final boolean g;

    /* loaded from: classes2.dex */
    static final class SkipLastTimedSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5677354903406201275L;
        final Subscriber<? super T> a;
        final long b;
        final TimeUnit c;
        final Scheduler d;
        final SpscLinkedArrayQueue<Object> e;
        final boolean f;
        Subscription g;
        final AtomicLong h = new AtomicLong();
        volatile boolean i;
        volatile boolean j;
        Throwable k;

        SkipLastTimedSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
            this.a = subscriber;
            this.b = j;
            this.c = timeUnit;
            this.d = scheduler;
            this.e = new SpscLinkedArrayQueue<>(i);
            this.f = z;
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.a;
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.e;
            boolean z = this.f;
            TimeUnit timeUnit = this.c;
            Scheduler scheduler = this.d;
            long j = this.b;
            int i = 1;
            do {
                long j2 = this.h.get();
                long j3 = 0;
                while (j3 != j2) {
                    boolean z2 = this.j;
                    Long l = (Long) spscLinkedArrayQueue.peek();
                    boolean z3 = l == null;
                    boolean z4 = (z3 || l.longValue() <= scheduler.now(timeUnit) - j) ? z3 : true;
                    if (a(z2, z4, subscriber, z)) {
                        return;
                    }
                    if (z4) {
                        break;
                    }
                    spscLinkedArrayQueue.poll();
                    subscriber.onNext(spscLinkedArrayQueue.poll());
                    j3++;
                }
                if (j3 != 0) {
                    BackpressureHelper.produced(this.h, j3);
                }
                i = addAndGet(-i);
            } while (i != 0);
        }

        boolean a(boolean z, boolean z2, Subscriber<? super T> subscriber, boolean z3) {
            if (this.i) {
                this.e.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (z3) {
                if (!z2) {
                    return false;
                }
                Throwable th = this.k;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
            Throwable th2 = this.k;
            if (th2 != null) {
                this.e.clear();
                subscriber.onError(th2);
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
            if (this.i) {
                return;
            }
            this.i = true;
            this.g.cancel();
            if (getAndIncrement() == 0) {
                this.e.clear();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.j = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.k = th;
            this.j = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.e.offer(Long.valueOf(this.d.now(this.c)), t);
            a();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.g, subscription)) {
                this.g = subscription;
                this.a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.h, j);
                a();
            }
        }
    }

    public FlowableSkipLastTimed(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
        super(flowable);
        this.c = j;
        this.d = timeUnit;
        this.e = scheduler;
        this.f = i;
        this.g = z;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe((FlowableSubscriber) new SkipLastTimedSubscriber(subscriber, this.c, this.d, this.e, this.f, this.g));
    }
}
