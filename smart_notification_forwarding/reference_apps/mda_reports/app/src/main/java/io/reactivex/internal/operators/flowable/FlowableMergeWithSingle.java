package io.reactivex.internal.operators.flowable;

import android.R;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableMergeWithSingle<T> extends AbstractFlowableWithUpstream<T, T> {
    final SingleSource<? extends T> c;

    /* loaded from: classes2.dex */
    static final class MergeWithObserver<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4592979584110982903L;
        final Subscriber<? super T> a;
        final AtomicReference<Subscription> b = new AtomicReference<>();
        final OtherObserver<T> c = new OtherObserver<>(this);
        final AtomicThrowable d = new AtomicThrowable();
        final AtomicLong e = new AtomicLong();
        final int f = Flowable.bufferSize();
        final int g;
        volatile SimplePlainQueue<T> h;
        T i;
        volatile boolean j;
        volatile boolean k;
        volatile int l;
        long m;
        int n;

        /* loaded from: classes2.dex */
        static final class OtherObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
            private static final long serialVersionUID = -2935427570954647017L;
            final MergeWithObserver<T> a;

            OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.a = mergeWithObserver;
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                this.a.a(th);
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(T t) {
                this.a.a((MergeWithObserver<T>) t);
            }
        }

        MergeWithObserver(Subscriber<? super T> subscriber) {
            this.a = subscriber;
            int i = this.f;
            this.g = i - (i >> 2);
        }

        void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        void a(T t) {
            if (compareAndSet(0, 1)) {
                long j = this.m;
                if (this.e.get() != j) {
                    this.m = j + 1;
                    this.a.onNext(t);
                    this.l = 2;
                } else {
                    this.i = t;
                    this.l = 1;
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            } else {
                this.i = t;
                this.l = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        void a(Throwable th) {
            if (!this.d.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                SubscriptionHelper.cancel(this.b);
                a();
            }
        }

        void b() {
            Subscriber<? super T> subscriber = this.a;
            long j = this.m;
            int i = this.n;
            int i2 = this.g;
            int i3 = 1;
            long j2 = j;
            int i4 = 1;
            while (true) {
                long j3 = this.e.get();
                while (j2 != j3) {
                    if (this.j) {
                        this.i = null;
                        this.h = null;
                        return;
                    }
                    if (this.d.get() != null) {
                        this.i = null;
                        this.h = null;
                        subscriber.onError(this.d.terminate());
                        return;
                    }
                    int i5 = this.l;
                    if (i5 == i3) {
                        T t = this.i;
                        this.i = null;
                        this.l = 2;
                        subscriber.onNext(t);
                        j2++;
                    } else {
                        boolean z = this.k;
                        SimplePlainQueue<T> simplePlainQueue = this.h;
                        R.bool poll = simplePlainQueue != null ? simplePlainQueue.poll() : null;
                        boolean z2 = poll == null;
                        if (z && z2 && i5 == 2) {
                            this.h = null;
                            subscriber.onComplete();
                            return;
                        } else {
                            if (z2) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j2++;
                            i++;
                            if (i == i2) {
                                this.b.get().request(i2);
                                i = 0;
                            }
                            i3 = 1;
                        }
                    }
                }
                if (j2 == j3) {
                    if (this.j) {
                        this.i = null;
                        this.h = null;
                        return;
                    }
                    if (this.d.get() != null) {
                        this.i = null;
                        this.h = null;
                        subscriber.onError(this.d.terminate());
                        return;
                    }
                    boolean z3 = this.k;
                    SimplePlainQueue<T> simplePlainQueue2 = this.h;
                    boolean z4 = simplePlainQueue2 == null || simplePlainQueue2.isEmpty();
                    if (z3 && z4 && this.l == 2) {
                        this.h = null;
                        subscriber.onComplete();
                        return;
                    }
                }
                this.m = j2;
                this.n = i;
                i4 = addAndGet(-i4);
                if (i4 == 0) {
                    return;
                } else {
                    i3 = 1;
                }
            }
        }

        SimplePlainQueue<T> c() {
            SimplePlainQueue<T> simplePlainQueue = this.h;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(Flowable.bufferSize());
            this.h = spscArrayQueue;
            return spscArrayQueue;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.j = true;
            SubscriptionHelper.cancel(this.b);
            DisposableHelper.dispose(this.c);
            if (getAndIncrement() == 0) {
                this.h = null;
                this.i = null;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.k = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.d.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                SubscriptionHelper.cancel(this.b);
                a();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (compareAndSet(0, 1)) {
                long j = this.m;
                if (this.e.get() != j) {
                    SimplePlainQueue<T> simplePlainQueue = this.h;
                    if (simplePlainQueue == null || simplePlainQueue.isEmpty()) {
                        this.m = j + 1;
                        this.a.onNext(t);
                        int i = this.n + 1;
                        if (i == this.g) {
                            this.n = 0;
                            this.b.get().request(i);
                        } else {
                            this.n = i;
                        }
                    } else {
                        simplePlainQueue.offer(t);
                    }
                } else {
                    c().offer(t);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                c().offer(t);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this.b, subscription, this.f);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            BackpressureHelper.add(this.e, j);
            a();
        }
    }

    public FlowableMergeWithSingle(Flowable<T> flowable, SingleSource<? extends T> singleSource) {
        super(flowable);
        this.c = singleSource;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(subscriber);
        subscriber.onSubscribe(mergeWithObserver);
        this.b.subscribe((FlowableSubscriber) mergeWithObserver);
        this.c.subscribe(mergeWithObserver.c);
    }
}
