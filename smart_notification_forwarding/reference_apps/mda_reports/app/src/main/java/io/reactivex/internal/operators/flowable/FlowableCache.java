package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.LinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableCache<T> extends AbstractFlowableWithUpstream<T, T> {
    final CacheState<T> c;
    final AtomicBoolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class CacheState<T> extends LinkedArrayList implements FlowableSubscriber<T> {
        static final ReplaySubscription[] j = new ReplaySubscription[0];
        static final ReplaySubscription[] k = new ReplaySubscription[0];
        final Flowable<T> f;
        final AtomicReference<Subscription> g;
        final AtomicReference<ReplaySubscription<T>[]> h;
        boolean i;

        CacheState(Flowable<T> flowable, int i) {
            super(i);
            this.g = new AtomicReference<>();
            this.f = flowable;
            this.h = new AtomicReference<>(j);
        }

        public boolean addChild(ReplaySubscription<T> replaySubscription) {
            ReplaySubscription<T>[] replaySubscriptionArr;
            ReplaySubscription<T>[] replaySubscriptionArr2;
            do {
                replaySubscriptionArr = this.h.get();
                if (replaySubscriptionArr == k) {
                    return false;
                }
                int length = replaySubscriptionArr.length;
                replaySubscriptionArr2 = new ReplaySubscription[length + 1];
                System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr2, 0, length);
                replaySubscriptionArr2[length] = replaySubscription;
            } while (!this.h.compareAndSet(replaySubscriptionArr, replaySubscriptionArr2));
            return true;
        }

        public void connect() {
            this.f.subscribe((FlowableSubscriber) this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.i) {
                return;
            }
            this.i = true;
            add(NotificationLite.complete());
            SubscriptionHelper.cancel(this.g);
            for (ReplaySubscription<T> replaySubscription : this.h.getAndSet(k)) {
                replaySubscription.replay();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.i) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.i = true;
            add(NotificationLite.error(th));
            SubscriptionHelper.cancel(this.g);
            for (ReplaySubscription<T> replaySubscription : this.h.getAndSet(k)) {
                replaySubscription.replay();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.i) {
                return;
            }
            add(NotificationLite.next(t));
            for (ReplaySubscription<T> replaySubscription : this.h.get()) {
                replaySubscription.replay();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this.g, subscription, Long.MAX_VALUE);
        }

        public void removeChild(ReplaySubscription<T> replaySubscription) {
            ReplaySubscription<T>[] replaySubscriptionArr;
            ReplaySubscription<T>[] replaySubscriptionArr2;
            do {
                replaySubscriptionArr = this.h.get();
                int length = replaySubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (replaySubscriptionArr[i2].equals(replaySubscription)) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    replaySubscriptionArr2 = j;
                } else {
                    ReplaySubscription<T>[] replaySubscriptionArr3 = new ReplaySubscription[length - 1];
                    System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr3, 0, i);
                    System.arraycopy(replaySubscriptionArr, i + 1, replaySubscriptionArr3, i, (length - i) - 1);
                    replaySubscriptionArr2 = replaySubscriptionArr3;
                }
            } while (!this.h.compareAndSet(replaySubscriptionArr, replaySubscriptionArr2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class ReplaySubscription<T> extends AtomicInteger implements Subscription {
        private static final long CANCELLED = Long.MIN_VALUE;
        private static final long serialVersionUID = -2557562030197141021L;
        final Subscriber<? super T> a;
        final CacheState<T> b;
        final AtomicLong c = new AtomicLong();
        Object[] d;
        int e;
        int f;
        long g;

        ReplaySubscription(Subscriber<? super T> subscriber, CacheState<T> cacheState) {
            this.a = subscriber;
            this.b = cacheState;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.c.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.b.removeChild(this);
            }
        }

        public void replay() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.a;
            AtomicLong atomicLong = this.c;
            long j = this.g;
            int i = 1;
            int i2 = 1;
            while (true) {
                long j2 = atomicLong.get();
                if (j2 == Long.MIN_VALUE) {
                    return;
                }
                int size = this.b.size();
                if (size != 0) {
                    Object[] objArr = this.d;
                    if (objArr == null) {
                        objArr = this.b.head();
                        this.d = objArr;
                    }
                    int length = objArr.length - i;
                    int i3 = this.f;
                    int i4 = this.e;
                    while (i3 < size && j != j2) {
                        if (atomicLong.get() == Long.MIN_VALUE) {
                            return;
                        }
                        if (i4 == length) {
                            objArr = (Object[]) objArr[length];
                            i4 = 0;
                        }
                        if (NotificationLite.accept(objArr[i4], subscriber)) {
                            return;
                        }
                        i4++;
                        i3++;
                        j++;
                    }
                    if (atomicLong.get() == Long.MIN_VALUE) {
                        return;
                    }
                    if (j2 == j) {
                        Object obj = objArr[i4];
                        if (NotificationLite.isComplete(obj)) {
                            subscriber.onComplete();
                            return;
                        } else if (NotificationLite.isError(obj)) {
                            subscriber.onError(NotificationLite.getError(obj));
                            return;
                        }
                    }
                    this.f = i3;
                    this.e = i4;
                    this.d = objArr;
                }
                this.g = j;
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                } else {
                    i = 1;
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.addCancel(this.c, j);
                replay();
            }
        }
    }

    public FlowableCache(Flowable<T> flowable, int i) {
        super(flowable);
        this.c = new CacheState<>(flowable, i);
        this.d = new AtomicBoolean();
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        boolean z;
        ReplaySubscription<T> replaySubscription = new ReplaySubscription<>(subscriber, this.c);
        subscriber.onSubscribe(replaySubscription);
        if (this.c.addChild(replaySubscription) && replaySubscription.c.get() == Long.MIN_VALUE) {
            this.c.removeChild(replaySubscription);
            z = false;
        } else {
            z = true;
        }
        if (!this.d.get() && this.d.compareAndSet(false, true)) {
            this.c.connect();
        }
        if (z) {
            replaySubscription.replay();
        }
    }
}
