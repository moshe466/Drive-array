package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableFlattenIterable<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super T, ? extends Iterable<? extends R>> c;
    final int d;

    /* loaded from: classes2.dex */
    static final class FlattenIterableSubscriber<T, R> extends BasicIntQueueSubscription<R> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -3096000382929934955L;
        final Subscriber<? super R> a;
        final Function<? super T, ? extends Iterable<? extends R>> b;
        final int c;
        final int d;
        Subscription f;
        SimpleQueue<T> g;
        volatile boolean h;
        volatile boolean i;
        Iterator<? extends R> k;
        int l;
        int m;
        final AtomicReference<Throwable> j = new AtomicReference<>();
        final AtomicLong e = new AtomicLong();

        FlattenIterableSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function, int i) {
            this.a = subscriber;
            this.b = function;
            this.c = i;
            this.d = i - (i >> 2);
        }

        void a(boolean z) {
            if (z) {
                int i = this.l + 1;
                if (i != this.d) {
                    this.l = i;
                } else {
                    this.l = 0;
                    this.f.request(i);
                }
            }
        }

        boolean a(boolean z, boolean z2, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
            if (this.i) {
                this.k = null;
                simpleQueue.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.j.get() == null) {
                if (!z2) {
                    return false;
                }
                subscriber.onComplete();
                return true;
            }
            Throwable terminate = ExceptionHelper.terminate(this.j);
            this.k = null;
            simpleQueue.clear();
            subscriber.onError(terminate);
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.i) {
                return;
            }
            this.i = true;
            this.f.cancel();
            if (getAndIncrement() == 0) {
                this.g.clear();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.k = null;
            this.g.clear();
        }

        /* JADX WARN: Code restructure failed: missing block: B:56:0x0103, code lost:
        
            if (r6 == null) goto L72;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void drain() {
            /*
                Method dump skipped, instructions count: 273
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlattenIterable.FlattenIterableSubscriber.drain():void");
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.k == null && this.g.isEmpty();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.h) {
                return;
            }
            this.h = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.h || !ExceptionHelper.addThrowable(this.j, th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.h = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.h) {
                return;
            }
            if (this.m != 0 || this.g.offer(t)) {
                drain();
            } else {
                onError(new MissingBackpressureException("Queue is full?!"));
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.m = requestFusion;
                        this.g = queueSubscription;
                        this.h = true;
                        this.a.onSubscribe(this);
                        return;
                    }
                    if (requestFusion == 2) {
                        this.m = requestFusion;
                        this.g = queueSubscription;
                        this.a.onSubscribe(this);
                        subscription.request(this.c);
                        return;
                    }
                }
                this.g = new SpscArrayQueue(this.c);
                this.a.onSubscribe(this);
                subscription.request(this.c);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public R poll() {
            Iterator<? extends R> it = this.k;
            while (true) {
                if (it == null) {
                    T poll = this.g.poll();
                    if (poll != null) {
                        it = this.b.apply(poll).iterator();
                        if (it.hasNext()) {
                            this.k = it;
                            break;
                        }
                        it = null;
                    } else {
                        return null;
                    }
                } else {
                    break;
                }
            }
            R r = (R) ObjectHelper.requireNonNull(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.k = null;
            }
            return r;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.e, j);
                drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return ((i & 1) == 0 || this.m != 1) ? 0 : 1;
        }
    }

    public FlowableFlattenIterable(Flowable<T> flowable, Function<? super T, ? extends Iterable<? extends R>> function, int i) {
        super(flowable);
        this.c = function;
        this.d = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super R> subscriber) {
        Flowable<T> flowable = this.b;
        if (!(flowable instanceof Callable)) {
            flowable.subscribe((FlowableSubscriber) new FlattenIterableSubscriber(subscriber, this.c, this.d));
            return;
        }
        try {
            Object call = ((Callable) flowable).call();
            if (call == null) {
                EmptySubscription.complete(subscriber);
                return;
            }
            try {
                FlowableFromIterable.subscribe(subscriber, this.c.apply(call).iterator());
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptySubscription.error(th, subscriber);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
