package io.reactivex.internal.operators.flowable;

import android.R;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableSwitchMap<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super T, ? extends Publisher<? extends R>> c;
    final int d;
    final boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class SwitchMapInnerSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        final SwitchMapSubscriber<T, R> a;
        final long b;
        final int c;
        volatile SimpleQueue<R> d;
        volatile boolean e;
        int f;

        SwitchMapInnerSubscriber(SwitchMapSubscriber<T, R> switchMapSubscriber, long j, int i) {
            this.a = switchMapSubscriber;
            this.b = j;
            this.c = i;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.a;
            if (this.b == switchMapSubscriber.k) {
                this.e = true;
                switchMapSubscriber.b();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.a;
            if (this.b != switchMapSubscriber.k || !switchMapSubscriber.f.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (!switchMapSubscriber.d) {
                switchMapSubscriber.h.cancel();
            }
            this.e = true;
            switchMapSubscriber.b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(R r) {
            SwitchMapSubscriber<T, R> switchMapSubscriber = this.a;
            if (this.b == switchMapSubscriber.k) {
                if (this.f != 0 || this.d.offer(r)) {
                    switchMapSubscriber.b();
                } else {
                    onError(new MissingBackpressureException("Queue full?!"));
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(7);
                    if (requestFusion == 1) {
                        this.f = requestFusion;
                        this.d = queueSubscription;
                        this.e = true;
                        this.a.b();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.f = requestFusion;
                        this.d = queueSubscription;
                        subscription.request(this.c);
                        return;
                    }
                }
                this.d = new SpscArrayQueue(this.c);
                subscription.request(this.c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class SwitchMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        static final SwitchMapInnerSubscriber<Object, Object> l = new SwitchMapInnerSubscriber<>(null, -1, 1);
        private static final long serialVersionUID = -3491074160481096299L;
        final Subscriber<? super R> a;
        final Function<? super T, ? extends Publisher<? extends R>> b;
        final int c;
        final boolean d;
        volatile boolean e;
        volatile boolean g;
        Subscription h;
        volatile long k;
        final AtomicReference<SwitchMapInnerSubscriber<T, R>> i = new AtomicReference<>();
        final AtomicLong j = new AtomicLong();
        final AtomicThrowable f = new AtomicThrowable();

        static {
            l.cancel();
        }

        SwitchMapSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i, boolean z) {
            this.a = subscriber;
            this.b = function;
            this.c = i;
            this.d = z;
        }

        void a() {
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber;
            SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber2 = this.i.get();
            SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber3 = l;
            if (switchMapInnerSubscriber2 == switchMapInnerSubscriber3 || (switchMapInnerSubscriber = (SwitchMapInnerSubscriber) this.i.getAndSet(switchMapInnerSubscriber3)) == l || switchMapInnerSubscriber == null) {
                return;
            }
            switchMapInnerSubscriber.cancel();
        }

        void b() {
            boolean z;
            R.bool boolVar;
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.a;
            int i = 1;
            while (!this.g) {
                if (this.e) {
                    if (this.d) {
                        if (this.i.get() == null) {
                            if (this.f.get() != null) {
                                subscriber.onError(this.f.terminate());
                                return;
                            } else {
                                subscriber.onComplete();
                                return;
                            }
                        }
                    } else if (this.f.get() != null) {
                        a();
                        subscriber.onError(this.f.terminate());
                        return;
                    } else if (this.i.get() == null) {
                        subscriber.onComplete();
                        return;
                    }
                }
                SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber = this.i.get();
                SimpleQueue<R> simpleQueue = switchMapInnerSubscriber != null ? switchMapInnerSubscriber.d : null;
                if (simpleQueue != null) {
                    if (switchMapInnerSubscriber.e) {
                        if (this.d) {
                            if (simpleQueue.isEmpty()) {
                                this.i.compareAndSet(switchMapInnerSubscriber, null);
                            }
                        } else if (this.f.get() != null) {
                            a();
                            subscriber.onError(this.f.terminate());
                            return;
                        } else if (simpleQueue.isEmpty()) {
                            this.i.compareAndSet(switchMapInnerSubscriber, null);
                        }
                    }
                    long j = this.j.get();
                    long j2 = 0;
                    while (true) {
                        z = false;
                        if (j2 != j) {
                            if (!this.g) {
                                boolean z2 = switchMapInnerSubscriber.e;
                                try {
                                    boolVar = simpleQueue.poll();
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    switchMapInnerSubscriber.cancel();
                                    this.f.addThrowable(th);
                                    boolVar = null;
                                    z2 = true;
                                }
                                boolean z3 = boolVar == null;
                                if (switchMapInnerSubscriber != this.i.get()) {
                                    break;
                                }
                                if (z2) {
                                    if (!this.d) {
                                        if (this.f.get() == null) {
                                            if (z3) {
                                                break;
                                            }
                                        } else {
                                            subscriber.onError(this.f.terminate());
                                            return;
                                        }
                                    } else if (z3) {
                                        break;
                                    }
                                }
                                if (z3) {
                                    break;
                                }
                                subscriber.onNext(boolVar);
                                j2++;
                            } else {
                                return;
                            }
                        } else {
                            break;
                        }
                    }
                    this.i.compareAndSet(switchMapInnerSubscriber, null);
                    z = true;
                    if (j2 != 0 && !this.g) {
                        if (j != Long.MAX_VALUE) {
                            this.j.addAndGet(-j2);
                        }
                        switchMapInnerSubscriber.get().request(j2);
                    }
                    if (z) {
                        continue;
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
            this.i.lazySet(null);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.g) {
                return;
            }
            this.g = true;
            this.h.cancel();
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.e) {
                return;
            }
            this.e = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.e || !this.f.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (!this.d) {
                a();
            }
            this.e = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber;
            if (this.e) {
                return;
            }
            long j = this.k + 1;
            this.k = j;
            SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber2 = this.i.get();
            if (switchMapInnerSubscriber2 != null) {
                switchMapInnerSubscriber2.cancel();
            }
            try {
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.b.apply(t), "The publisher returned is null");
                SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber3 = new SwitchMapInnerSubscriber<>(this, j, this.c);
                do {
                    switchMapInnerSubscriber = this.i.get();
                    if (switchMapInnerSubscriber == l) {
                        return;
                    }
                } while (!this.i.compareAndSet(switchMapInnerSubscriber, switchMapInnerSubscriber3));
                publisher.subscribe(switchMapInnerSubscriber3);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.h.cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.h, subscription)) {
                this.h = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.j, j);
                if (this.k == 0) {
                    this.h.request(Long.MAX_VALUE);
                } else {
                    b();
                }
            }
        }
    }

    public FlowableSwitchMap(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i, boolean z) {
        super(flowable);
        this.c = function;
        this.d = i;
        this.e = z;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> subscriber) {
        if (FlowableScalarXMap.tryScalarXMapSubscribe(this.b, subscriber, this.c)) {
            return;
        }
        this.b.subscribe((FlowableSubscriber) new SwitchMapSubscriber(subscriber, this.c, this.d, this.e));
    }
}
