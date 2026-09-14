package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Action;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableOnBackpressureBufferStrategy<T> extends AbstractFlowableWithUpstream<T, T> {
    final long c;
    final Action d;
    final BackpressureOverflowStrategy e;

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[BackpressureOverflowStrategy.values().length];

        static {
            try {
                a[BackpressureOverflowStrategy.DROP_LATEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BackpressureOverflowStrategy.DROP_OLDEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class OnBackpressureBufferStrategySubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 3240706908776709697L;
        final Subscriber<? super T> a;
        final Action b;
        final BackpressureOverflowStrategy c;
        final long d;
        final AtomicLong e = new AtomicLong();
        final Deque<T> f = new ArrayDeque();
        Subscription g;
        volatile boolean h;
        volatile boolean i;
        Throwable j;

        OnBackpressureBufferStrategySubscriber(Subscriber<? super T> subscriber, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy, long j) {
            this.a = subscriber;
            this.b = action;
            this.c = backpressureOverflowStrategy;
            this.d = j;
        }

        void a() {
            boolean isEmpty;
            T poll;
            if (getAndIncrement() != 0) {
                return;
            }
            Deque<T> deque = this.f;
            Subscriber<? super T> subscriber = this.a;
            int i = 1;
            do {
                long j = this.e.get();
                long j2 = 0;
                while (j2 != j) {
                    if (this.h) {
                        a(deque);
                        return;
                    }
                    boolean z = this.i;
                    synchronized (deque) {
                        poll = deque.poll();
                    }
                    boolean z2 = poll == null;
                    if (z) {
                        Throwable th = this.j;
                        if (th != null) {
                            a(deque);
                            subscriber.onError(th);
                            return;
                        } else if (z2) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.onNext(poll);
                    j2++;
                }
                if (j2 == j) {
                    if (this.h) {
                        a(deque);
                        return;
                    }
                    boolean z3 = this.i;
                    synchronized (deque) {
                        isEmpty = deque.isEmpty();
                    }
                    if (z3) {
                        Throwable th2 = this.j;
                        if (th2 != null) {
                            a(deque);
                            subscriber.onError(th2);
                            return;
                        } else if (isEmpty) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                if (j2 != 0) {
                    BackpressureHelper.produced(this.e, j2);
                }
                i = addAndGet(-i);
            } while (i != 0);
        }

        void a(Deque<T> deque) {
            synchronized (deque) {
                deque.clear();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.h = true;
            this.g.cancel();
            if (getAndIncrement() == 0) {
                a(this.f);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.i = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.i) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.j = th;
            this.i = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            boolean z;
            boolean z2;
            MissingBackpressureException th;
            if (this.i) {
                return;
            }
            Deque<T> deque = this.f;
            synchronized (deque) {
                z = false;
                z2 = true;
                if (deque.size() == this.d) {
                    int i = AnonymousClass1.a[this.c.ordinal()];
                    if (i == 1) {
                        deque.pollLast();
                    } else if (i == 2) {
                        deque.poll();
                    }
                    deque.offer(t);
                    z = true;
                } else {
                    deque.offer(t);
                }
                z2 = false;
            }
            if (z) {
                Action action = this.b;
                if (action == null) {
                    return;
                }
                try {
                    action.run();
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    Exceptions.throwIfFatal(th);
                    this.g.cancel();
                }
            } else if (!z2) {
                a();
                return;
            } else {
                this.g.cancel();
                th = new MissingBackpressureException();
            }
            onError(th);
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
                BackpressureHelper.add(this.e, j);
                a();
            }
        }
    }

    public FlowableOnBackpressureBufferStrategy(Flowable<T> flowable, long j, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy) {
        super(flowable);
        this.c = j;
        this.d = action;
        this.e = backpressureOverflowStrategy;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.b.subscribe((FlowableSubscriber) new OnBackpressureBufferStrategySubscriber(subscriber, this.d, this.e, this.c));
    }
}
