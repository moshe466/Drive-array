package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableWindowBoundarySelector<T, B, V> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final Publisher<B> c;
    final Function<? super B, ? extends Publisher<V>> d;
    final int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class OperatorWindowBoundaryCloseSubscriber<T, V> extends DisposableSubscriber<V> {
        final WindowBoundaryMainSubscriber<T, ?, V> b;
        final UnicastProcessor<T> c;
        boolean d;

        OperatorWindowBoundaryCloseSubscriber(WindowBoundaryMainSubscriber<T, ?, V> windowBoundaryMainSubscriber, UnicastProcessor<T> unicastProcessor) {
            this.b = windowBoundaryMainSubscriber;
            this.c = unicastProcessor;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.d) {
                return;
            }
            this.d = true;
            this.b.a((OperatorWindowBoundaryCloseSubscriber) this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.onError(th);
            } else {
                this.d = true;
                this.b.a(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(V v) {
            a();
            onComplete();
        }
    }

    /* loaded from: classes2.dex */
    static final class OperatorWindowBoundaryOpenSubscriber<T, B> extends DisposableSubscriber<B> {
        final WindowBoundaryMainSubscriber<T, B, ?> b;

        OperatorWindowBoundaryOpenSubscriber(WindowBoundaryMainSubscriber<T, B, ?> windowBoundaryMainSubscriber) {
            this.b = windowBoundaryMainSubscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.b.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.b.a(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(B b) {
            this.b.a((WindowBoundaryMainSubscriber<T, B, ?>) b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class WindowBoundaryMainSubscriber<T, B, V> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription {
        final Publisher<B> h;
        final Function<? super B, ? extends Publisher<V>> i;
        final int j;
        final CompositeDisposable k;
        Subscription l;
        final AtomicReference<Disposable> m;
        final List<UnicastProcessor<T>> n;
        final AtomicLong o;

        WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> subscriber, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int i) {
            super(subscriber, new MpscLinkedQueue());
            this.m = new AtomicReference<>();
            this.o = new AtomicLong();
            this.h = publisher;
            this.i = function;
            this.j = i;
            this.k = new CompositeDisposable();
            this.n = new ArrayList();
            this.o.lazySet(1L);
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            MissingBackpressureException th;
            SimpleQueue simpleQueue = this.d;
            Subscriber<? super V> subscriber = this.c;
            List<UnicastProcessor<T>> list = this.n;
            int i = 1;
            while (true) {
                boolean z = this.f;
                Object poll = simpleQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    dispose();
                    Throwable th2 = this.g;
                    if (th2 != null) {
                        Iterator<UnicastProcessor<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th2);
                        }
                    } else {
                        Iterator<UnicastProcessor<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    list.clear();
                    return;
                }
                if (z2) {
                    i = leave(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (poll instanceof WindowOperation) {
                    WindowOperation windowOperation = (WindowOperation) poll;
                    UnicastProcessor<T> unicastProcessor = windowOperation.a;
                    if (unicastProcessor != null) {
                        if (list.remove(unicastProcessor)) {
                            windowOperation.a.onComplete();
                            if (this.o.decrementAndGet() == 0) {
                                dispose();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.e) {
                        UnicastProcessor<T> create = UnicastProcessor.create(this.j);
                        long requested = requested();
                        if (requested != 0) {
                            list.add(create);
                            subscriber.onNext(create);
                            if (requested != Long.MAX_VALUE) {
                                produced(1L);
                            }
                            try {
                                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.i.apply(windowOperation.b), "The publisher supplied is null");
                                OperatorWindowBoundaryCloseSubscriber operatorWindowBoundaryCloseSubscriber = new OperatorWindowBoundaryCloseSubscriber(this, create);
                                if (this.k.add(operatorWindowBoundaryCloseSubscriber)) {
                                    this.o.getAndIncrement();
                                    publisher.subscribe(operatorWindowBoundaryCloseSubscriber);
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                this.e = true;
                            }
                        } else {
                            this.e = true;
                            th = new MissingBackpressureException("Could not deliver new window due to lack of requests");
                        }
                        subscriber.onError(th);
                    }
                } else {
                    Iterator<UnicastProcessor<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(NotificationLite.getValue(poll));
                    }
                }
            }
        }

        void a(OperatorWindowBoundaryCloseSubscriber<T, V> operatorWindowBoundaryCloseSubscriber) {
            this.k.delete(operatorWindowBoundaryCloseSubscriber);
            this.d.offer(new WindowOperation(operatorWindowBoundaryCloseSubscriber.c, null));
            if (enter()) {
                a();
            }
        }

        void a(B b) {
            this.d.offer(new WindowOperation(null, b));
            if (enter()) {
                a();
            }
        }

        void a(Throwable th) {
            this.l.cancel();
            this.k.dispose();
            DisposableHelper.dispose(this.m);
            this.c.onError(th);
        }

        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public boolean accept(Subscriber<? super Flowable<T>> subscriber, Object obj) {
            return false;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.e = true;
        }

        void dispose() {
            this.k.dispose();
            DisposableHelper.dispose(this.m);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f) {
                return;
            }
            this.f = true;
            if (enter()) {
                a();
            }
            if (this.o.decrementAndGet() == 0) {
                this.k.dispose();
            }
            this.c.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.g = th;
            this.f = true;
            if (enter()) {
                a();
            }
            if (this.o.decrementAndGet() == 0) {
                this.k.dispose();
            }
            this.c.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.f) {
                return;
            }
            if (fastEnter()) {
                Iterator<UnicastProcessor<T>> it = this.n.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.d.offer(NotificationLite.next(t));
                if (!enter()) {
                    return;
                }
            }
            a();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.l, subscription)) {
                this.l = subscription;
                this.c.onSubscribe(this);
                if (this.e) {
                    return;
                }
                OperatorWindowBoundaryOpenSubscriber operatorWindowBoundaryOpenSubscriber = new OperatorWindowBoundaryOpenSubscriber(this);
                if (this.m.compareAndSet(null, operatorWindowBoundaryOpenSubscriber)) {
                    this.o.getAndIncrement();
                    subscription.request(Long.MAX_VALUE);
                    this.h.subscribe(operatorWindowBoundaryOpenSubscriber);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class WindowOperation<T, B> {
        final UnicastProcessor<T> a;
        final B b;

        WindowOperation(UnicastProcessor<T> unicastProcessor, B b) {
            this.a = unicastProcessor;
            this.b = b;
        }
    }

    public FlowableWindowBoundarySelector(Flowable<T> flowable, Publisher<B> publisher, Function<? super B, ? extends Publisher<V>> function, int i) {
        super(flowable);
        this.c = publisher;
        this.d = function;
        this.e = i;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        this.b.subscribe((FlowableSubscriber) new WindowBoundaryMainSubscriber(new SerializedSubscriber(subscriber), this.c, this.d, this.e));
    }
}
