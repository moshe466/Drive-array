package io.reactivex.internal.operators.parallel;

import android.R;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes3.dex */
public final class ParallelSortedJoin<T> extends Flowable<T> {
    final ParallelFlowable<List<T>> b;
    final Comparator<? super T> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class SortedJoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<List<T>> {
        private static final long serialVersionUID = 6751017204873808094L;
        final SortedJoinSubscription<T> a;
        final int b;

        SortedJoinInnerSubscriber(SortedJoinSubscription<T> sortedJoinSubscription, int i) {
            this.a = sortedJoinSubscription;
            this.b = i;
        }

        void a() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.a.a(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(List<T> list) {
            this.a.a(list, this.b);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class SortedJoinSubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3481980673745556697L;
        final Subscriber<? super T> a;
        final SortedJoinInnerSubscriber<T>[] b;
        final List<T>[] c;
        final int[] d;
        final Comparator<? super T> e;
        volatile boolean g;
        final AtomicLong f = new AtomicLong();
        final AtomicInteger h = new AtomicInteger();
        final AtomicReference<Throwable> i = new AtomicReference<>();

        SortedJoinSubscription(Subscriber<? super T> subscriber, int i, Comparator<? super T> comparator) {
            this.a = subscriber;
            this.e = comparator;
            SortedJoinInnerSubscriber<T>[] sortedJoinInnerSubscriberArr = new SortedJoinInnerSubscriber[i];
            for (int i2 = 0; i2 < i; i2++) {
                sortedJoinInnerSubscriberArr[i2] = new SortedJoinInnerSubscriber<>(this, i2);
            }
            this.b = sortedJoinInnerSubscriberArr;
            this.c = new List[i];
            this.d = new int[i];
            this.h.lazySet(i);
        }

        void a() {
            for (SortedJoinInnerSubscriber<T> sortedJoinInnerSubscriber : this.b) {
                sortedJoinInnerSubscriber.a();
            }
        }

        void a(Throwable th) {
            if (this.i.compareAndSet(null, th)) {
                b();
            } else if (th != this.i.get()) {
                RxJavaPlugins.onError(th);
            }
        }

        void a(List<T> list, int i) {
            this.c[i] = list;
            if (this.h.decrementAndGet() == 0) {
                b();
            }
        }

        void b() {
            boolean z;
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.a;
            List<T>[] listArr = this.c;
            int[] iArr = this.d;
            int length = iArr.length;
            int i = 1;
            while (true) {
                long j = this.f.get();
                long j2 = 0;
                while (j2 != j) {
                    if (this.g) {
                        Arrays.fill(listArr, (Object) null);
                        return;
                    }
                    Throwable th = this.i.get();
                    if (th != null) {
                        a();
                        Arrays.fill(listArr, (Object) null);
                        subscriber.onError(th);
                        return;
                    }
                    R.bool boolVar = null;
                    int i2 = -1;
                    for (int i3 = 0; i3 < length; i3++) {
                        List<T> list = listArr[i3];
                        int i4 = iArr[i3];
                        if (list.size() != i4) {
                            T t = list.get(i4);
                            if (boolVar != null) {
                                try {
                                    if (!(this.e.compare(boolVar, t) > 0)) {
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    a();
                                    Arrays.fill(listArr, (Object) null);
                                    if (!this.i.compareAndSet(null, th2)) {
                                        RxJavaPlugins.onError(th2);
                                    }
                                    subscriber.onError(this.i.get());
                                    return;
                                }
                            }
                            boolVar = (Object) t;
                            i2 = i3;
                        }
                    }
                    if (boolVar == null) {
                        Arrays.fill(listArr, (Object) null);
                        subscriber.onComplete();
                        return;
                    } else {
                        subscriber.onNext(boolVar);
                        iArr[i2] = iArr[i2] + 1;
                        j2++;
                    }
                }
                if (j2 == j) {
                    if (this.g) {
                        Arrays.fill(listArr, (Object) null);
                        return;
                    }
                    Throwable th3 = this.i.get();
                    if (th3 != null) {
                        a();
                        Arrays.fill(listArr, (Object) null);
                        subscriber.onError(th3);
                        return;
                    }
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length) {
                            z = true;
                            break;
                        } else {
                            if (iArr[i5] != listArr[i5].size()) {
                                z = false;
                                break;
                            }
                            i5++;
                        }
                    }
                    if (z) {
                        Arrays.fill(listArr, (Object) null);
                        subscriber.onComplete();
                        return;
                    }
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.f.addAndGet(-j2);
                }
                int i6 = get();
                if (i6 == i && (i6 = addAndGet(-i)) == 0) {
                    return;
                } else {
                    i = i6;
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.g) {
                return;
            }
            this.g = true;
            a();
            if (getAndIncrement() == 0) {
                Arrays.fill(this.c, (Object) null);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.f, j);
                if (this.h.get() == 0) {
                    b();
                }
            }
        }
    }

    public ParallelSortedJoin(ParallelFlowable<List<T>> parallelFlowable, Comparator<? super T> comparator) {
        this.b = parallelFlowable;
        this.c = comparator;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        SortedJoinSubscription sortedJoinSubscription = new SortedJoinSubscription(subscriber, this.b.parallelism(), this.c);
        subscriber.onSubscribe(sortedJoinSubscription);
        this.b.subscribe(sortedJoinSubscription.b);
    }
}
