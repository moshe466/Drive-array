package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableOnBackpressureLatest<T> extends AbstractFlowableWithUpstream<T, T> {

    /* loaded from: classes2.dex */
    static final class BackpressureLatestSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 163080509307634843L;
        final Subscriber<? super T> a;
        Subscription b;
        volatile boolean c;
        Throwable d;
        volatile boolean e;
        final AtomicLong f = new AtomicLong();
        final AtomicReference<T> g = new AtomicReference<>();

        BackpressureLatestSubscriber(Subscriber<? super T> subscriber) {
            this.a = subscriber;
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.a;
            AtomicLong atomicLong = this.f;
            AtomicReference<T> atomicReference = this.g;
            int i = 1;
            do {
                long j = 0;
                while (true) {
                    if (j == atomicLong.get()) {
                        break;
                    }
                    boolean z = this.c;
                    T andSet = atomicReference.getAndSet(null);
                    boolean z2 = andSet == null;
                    if (a(z, z2, subscriber, atomicReference)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.onNext(andSet);
                    j++;
                }
                if (j == atomicLong.get()) {
                    if (a(this.c, atomicReference.get() == null, subscriber, atomicReference)) {
                        return;
                    }
                }
                if (j != 0) {
                    BackpressureHelper.produced(atomicLong, j);
                }
                i = addAndGet(-i);
            } while (i != 0);
        }

        boolean a(boolean z, boolean z2, Subscriber<?> subscriber, AtomicReference<T> atomicReference) {
            if (this.e) {
                atomicReference.lazySet(null);
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.d;
            if (th != null) {
                atomicReference.lazySet(null);
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
            if (this.e) {
                return;
            }
            this.e = true;
            this.b.cancel();
            if (getAndIncrement() == 0) {
                this.g.lazySet(null);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.c = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.d = th;
            this.c = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.g.lazySet(t);
            a();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.b, subscription)) {
                this.b = subscription;
                this.a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.f, j);
                a();
            }
        }
    }

    public FlowableOnBackpressureLatest(Flowable<T> flowable) {
        super(flowable);
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe((FlowableSubscriber) new BackpressureLatestSubscriber(subscriber));
    }
}
