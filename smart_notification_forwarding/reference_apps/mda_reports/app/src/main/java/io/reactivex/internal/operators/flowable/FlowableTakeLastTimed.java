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
public final class FlowableTakeLastTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final long c;
    final long d;
    final TimeUnit e;
    final Scheduler f;
    final int g;
    final boolean h;

    /* loaded from: classes2.dex */
    static final class TakeLastTimedSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5677354903406201275L;
        final Subscriber<? super T> a;
        final long b;
        final long c;
        final TimeUnit d;
        final Scheduler e;
        final SpscLinkedArrayQueue<Object> f;
        final boolean g;
        Subscription h;
        final AtomicLong i = new AtomicLong();
        volatile boolean j;
        volatile boolean k;
        Throwable l;

        TakeLastTimedSubscriber(Subscriber<? super T> subscriber, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
            this.a = subscriber;
            this.b = j;
            this.c = j2;
            this.d = timeUnit;
            this.e = scheduler;
            this.f = new SpscLinkedArrayQueue<>(i);
            this.g = z;
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.a;
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f;
            boolean z = this.g;
            int i = 1;
            do {
                if (this.k) {
                    if (a(spscLinkedArrayQueue.isEmpty(), subscriber, z)) {
                        return;
                    }
                    long j = this.i.get();
                    long j2 = 0;
                    while (true) {
                        if (a(spscLinkedArrayQueue.peek() == null, subscriber, z)) {
                            return;
                        }
                        if (j != j2) {
                            spscLinkedArrayQueue.poll();
                            subscriber.onNext(spscLinkedArrayQueue.poll());
                            j2++;
                        } else if (j2 != 0) {
                            BackpressureHelper.produced(this.i, j2);
                        }
                    }
                }
                i = addAndGet(-i);
            } while (i != 0);
        }

        void a(long j, SpscLinkedArrayQueue<Object> spscLinkedArrayQueue) {
            long j2 = this.c;
            long j3 = this.b;
            boolean z = j3 == Long.MAX_VALUE;
            while (!spscLinkedArrayQueue.isEmpty()) {
                if (((Long) spscLinkedArrayQueue.peek()).longValue() >= j - j2 && (z || (spscLinkedArrayQueue.size() >> 1) <= j3)) {
                    return;
                }
                spscLinkedArrayQueue.poll();
                spscLinkedArrayQueue.poll();
            }
        }

        boolean a(boolean z, Subscriber<? super T> subscriber, boolean z2) {
            if (this.j) {
                this.f.clear();
                return true;
            }
            if (z2) {
                if (!z) {
                    return false;
                }
                Throwable th = this.l;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
            Throwable th2 = this.l;
            if (th2 != null) {
                this.f.clear();
                subscriber.onError(th2);
                return true;
            }
            if (!z) {
                return false;
            }
            subscriber.onComplete();
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.j) {
                return;
            }
            this.j = true;
            this.h.cancel();
            if (getAndIncrement() == 0) {
                this.f.clear();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            a(this.e.now(this.d), this.f);
            this.k = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.g) {
                a(this.e.now(this.d), this.f);
            }
            this.l = th;
            this.k = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f;
            long now = this.e.now(this.d);
            spscLinkedArrayQueue.offer(Long.valueOf(now), t);
            a(now, spscLinkedArrayQueue);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.h, subscription)) {
                this.h = subscription;
                this.a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.i, j);
                a();
            }
        }
    }

    public FlowableTakeLastTimed(Flowable<T> flowable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
        super(flowable);
        this.c = j;
        this.d = j2;
        this.e = timeUnit;
        this.f = scheduler;
        this.g = i;
        this.h = z;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe((FlowableSubscriber) new TakeLastTimedSubscriber(subscriber, this.c, this.d, this.e, this.f, this.g, this.h));
    }
}
