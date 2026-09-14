package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.subscribers.SubscriberResourceWrapper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableReplay<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T>, Disposable {
    static final Callable f = new DefaultUnboundedFactory();
    final Flowable<T> b;
    final AtomicReference<ReplaySubscriber<T>> c;
    final Callable<? extends ReplayBuffer<T>> d;
    final Publisher<T> e;

    /* loaded from: classes2.dex */
    static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        Node a;
        int b;
        long c;

        BoundedReplayBuffer() {
            Node node = new Node(null, 0L);
            this.a = node;
            set(node);
        }

        Node a() {
            return get();
        }

        Object a(Object obj) {
            return obj;
        }

        final void a(Node node) {
            this.a.set(node);
            this.a = node;
            this.b++;
        }

        Object b(Object obj) {
            return obj;
        }

        final void b() {
            Node node = get().get();
            if (node == null) {
                throw new IllegalStateException("Empty list!");
            }
            this.b--;
            b(node);
        }

        final void b(Node node) {
            set(node);
        }

        final void c() {
            Node node = get();
            if (node.a != null) {
                Node node2 = new Node(null, 0L);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void complete() {
            Object a = a(NotificationLite.complete());
            long j = this.c + 1;
            this.c = j;
            a(new Node(a, j));
            e();
        }

        void d() {
        }

        void e() {
            c();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void error(Throwable th) {
            Object a = a(NotificationLite.error(th));
            long j = this.c + 1;
            this.c = j;
            a(new Node(a, j));
            e();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void next(T t) {
            Object a = a(NotificationLite.next(t));
            long j = this.c + 1;
            this.c = j;
            a(new Node(a, j));
            d();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void replay(InnerSubscription<T> innerSubscription) {
            Node node;
            synchronized (innerSubscription) {
                if (innerSubscription.e) {
                    innerSubscription.f = true;
                    return;
                }
                innerSubscription.e = true;
                while (!innerSubscription.isDisposed()) {
                    long j = innerSubscription.get();
                    boolean z = j == Long.MAX_VALUE;
                    Node node2 = (Node) innerSubscription.a();
                    if (node2 == null) {
                        node2 = a();
                        innerSubscription.c = node2;
                        BackpressureHelper.add(innerSubscription.d, node2.b);
                    }
                    long j2 = 0;
                    while (j != 0 && (node = node2.get()) != null) {
                        Object b = b(node.a);
                        try {
                            if (NotificationLite.accept(b, innerSubscription.b)) {
                                innerSubscription.c = null;
                                return;
                            }
                            j2++;
                            j--;
                            if (innerSubscription.isDisposed()) {
                                return;
                            } else {
                                node2 = node;
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            innerSubscription.c = null;
                            innerSubscription.dispose();
                            if (NotificationLite.isError(b) || NotificationLite.isComplete(b)) {
                                return;
                            }
                            innerSubscription.b.onError(th);
                            return;
                        }
                    }
                    if (j2 != 0) {
                        innerSubscription.c = node2;
                        if (!z) {
                            innerSubscription.produced(j2);
                        }
                    }
                    synchronized (innerSubscription) {
                        if (!innerSubscription.f) {
                            innerSubscription.e = false;
                            return;
                        }
                        innerSubscription.f = false;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class ConnectableFlowableReplay<T> extends ConnectableFlowable<T> {
        private final ConnectableFlowable<T> cf;
        private final Flowable<T> observable;

        ConnectableFlowableReplay(ConnectableFlowable<T> connectableFlowable, Flowable<T> flowable) {
            this.cf = connectableFlowable;
            this.observable = flowable;
        }

        @Override // io.reactivex.flowables.ConnectableFlowable
        public void connect(Consumer<? super Disposable> consumer) {
            this.cf.connect(consumer);
        }

        @Override // io.reactivex.Flowable
        protected void subscribeActual(Subscriber<? super T> subscriber) {
            this.observable.subscribe(subscriber);
        }
    }

    /* loaded from: classes2.dex */
    static final class DefaultUnboundedFactory implements Callable<Object> {
        DefaultUnboundedFactory() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class InnerSubscription<T> extends AtomicLong implements Subscription, Disposable {
        private static final long serialVersionUID = -4453897557930727610L;
        final ReplaySubscriber<T> a;
        final Subscriber<? super T> b;
        Object c;
        final AtomicLong d = new AtomicLong();
        boolean e;
        boolean f;

        InnerSubscription(ReplaySubscriber<T> replaySubscriber, Subscriber<? super T> subscriber) {
            this.a = replaySubscriber;
            this.b = subscriber;
        }

        <U> U a() {
            return (U) this.c;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.a.b(this);
                this.a.a();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == Long.MIN_VALUE;
        }

        public long produced(long j) {
            return BackpressureHelper.producedCancel(this, j);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (!SubscriptionHelper.validate(j) || BackpressureHelper.addCancel(this, j) == Long.MIN_VALUE) {
                return;
            }
            BackpressureHelper.add(this.d, j);
            this.a.a();
            this.a.a.replay(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class MulticastFlowable<R, U> extends Flowable<R> {
        private final Callable<? extends ConnectableFlowable<U>> connectableFactory;
        private final Function<? super Flowable<U>, ? extends Publisher<R>> selector;

        /* loaded from: classes2.dex */
        final class DisposableConsumer implements Consumer<Disposable> {
            private final SubscriberResourceWrapper<R> srw;

            DisposableConsumer(MulticastFlowable multicastFlowable, SubscriberResourceWrapper<R> subscriberResourceWrapper) {
                this.srw = subscriberResourceWrapper;
            }

            @Override // io.reactivex.functions.Consumer
            public void accept(Disposable disposable) {
                this.srw.setResource(disposable);
            }
        }

        MulticastFlowable(Callable<? extends ConnectableFlowable<U>> callable, Function<? super Flowable<U>, ? extends Publisher<R>> function) {
            this.connectableFactory = callable;
            this.selector = function;
        }

        @Override // io.reactivex.Flowable
        protected void subscribeActual(Subscriber<? super R> subscriber) {
            try {
                ConnectableFlowable connectableFlowable = (ConnectableFlowable) ObjectHelper.requireNonNull(this.connectableFactory.call(), "The connectableFactory returned null");
                try {
                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.selector.apply(connectableFlowable), "The selector returned a null Publisher");
                    SubscriberResourceWrapper subscriberResourceWrapper = new SubscriberResourceWrapper(subscriber);
                    publisher.subscribe(subscriberResourceWrapper);
                    connectableFlowable.connect(new DisposableConsumer(this, subscriberResourceWrapper));
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final Object a;
        final long b;

        Node(Object obj, long j) {
            this.a = obj;
            this.b = j;
        }
    }

    /* loaded from: classes2.dex */
    interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerSubscription<T> innerSubscription);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class ReplayBufferTask<T> implements Callable<ReplayBuffer<T>> {
        private final int bufferSize;

        ReplayBufferTask(int i) {
            this.bufferSize = i;
        }

        @Override // java.util.concurrent.Callable
        public ReplayBuffer<T> call() {
            return new SizeBoundReplayBuffer(this.bufferSize);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class ReplayPublisher<T> implements Publisher<T> {
        private final Callable<? extends ReplayBuffer<T>> bufferFactory;
        private final AtomicReference<ReplaySubscriber<T>> curr;

        ReplayPublisher(AtomicReference<ReplaySubscriber<T>> atomicReference, Callable<? extends ReplayBuffer<T>> callable) {
            this.curr = atomicReference;
            this.bufferFactory = callable;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super T> subscriber) {
            ReplaySubscriber<T> replaySubscriber;
            while (true) {
                replaySubscriber = this.curr.get();
                if (replaySubscriber != null) {
                    break;
                }
                try {
                    ReplaySubscriber<T> replaySubscriber2 = new ReplaySubscriber<>(this.bufferFactory.call());
                    if (this.curr.compareAndSet(null, replaySubscriber2)) {
                        replaySubscriber = replaySubscriber2;
                        break;
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptySubscription.error(th, subscriber);
                    return;
                }
            }
            InnerSubscription<T> innerSubscription = new InnerSubscription<>(replaySubscriber, subscriber);
            subscriber.onSubscribe(innerSubscription);
            replaySubscriber.a(innerSubscription);
            if (innerSubscription.isDisposed()) {
                replaySubscriber.b(innerSubscription);
            } else {
                replaySubscriber.a();
                replaySubscriber.a.replay(innerSubscription);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class ReplaySubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {
        static final InnerSubscription[] h = new InnerSubscription[0];
        static final InnerSubscription[] i = new InnerSubscription[0];
        private static final long serialVersionUID = 7224554242710036740L;
        final ReplayBuffer<T> a;
        boolean b;
        long f;
        long g;
        final AtomicInteger e = new AtomicInteger();
        final AtomicReference<InnerSubscription<T>[]> c = new AtomicReference<>(h);
        final AtomicBoolean d = new AtomicBoolean();

        ReplaySubscriber(ReplayBuffer<T> replayBuffer) {
            this.a = replayBuffer;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0070 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:24:? A[LOOP:0: B:6:0x000a->B:24:?, LOOP_END, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void a() {
            /*
                r11 = this;
                java.util.concurrent.atomic.AtomicInteger r0 = r11.e
                int r0 = r0.getAndIncrement()
                if (r0 == 0) goto L9
                return
            L9:
                r0 = 1
            La:
                boolean r1 = r11.isDisposed()
                if (r1 == 0) goto L11
                return
            L11:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription<T>[]> r1 = r11.c
                java.lang.Object r1 = r1.get()
                io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription[] r1 = (io.reactivex.internal.operators.flowable.FlowableReplay.InnerSubscription[]) r1
                long r2 = r11.f
                int r4 = r1.length
                r5 = 0
                r6 = r2
            L1e:
                if (r5 >= r4) goto L2f
                r8 = r1[r5]
                java.util.concurrent.atomic.AtomicLong r8 = r8.d
                long r8 = r8.get()
                long r6 = java.lang.Math.max(r6, r8)
                int r5 = r5 + 1
                goto L1e
            L2f:
                long r4 = r11.g
                java.lang.Object r1 = r11.get()
                org.reactivestreams.Subscription r1 = (org.reactivestreams.Subscription) r1
                long r2 = r6 - r2
                r8 = 0
                int r10 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
                if (r10 == 0) goto L5c
                r11.f = r6
                if (r1 == 0) goto L4f
                int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
                if (r6 == 0) goto L4b
                r11.g = r8
                long r4 = r4 + r2
                goto L64
            L4b:
                r1.request(r2)
                goto L67
            L4f:
                long r4 = r4 + r2
                int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
                if (r1 >= 0) goto L59
                r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            L59:
                r11.g = r4
                goto L67
            L5c:
                int r2 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
                if (r2 == 0) goto L67
                if (r1 == 0) goto L67
                r11.g = r8
            L64:
                r1.request(r4)
            L67:
                java.util.concurrent.atomic.AtomicInteger r1 = r11.e
                int r0 = -r0
                int r0 = r1.addAndGet(r0)
                if (r0 != 0) goto La
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableReplay.ReplaySubscriber.a():void");
        }

        boolean a(InnerSubscription<T> innerSubscription) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription<T>[] innerSubscriptionArr2;
            if (innerSubscription == null) {
                throw new NullPointerException();
            }
            do {
                innerSubscriptionArr = this.c.get();
                if (innerSubscriptionArr == i) {
                    return false;
                }
                int length = innerSubscriptionArr.length;
                innerSubscriptionArr2 = new InnerSubscription[length + 1];
                System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr2, 0, length);
                innerSubscriptionArr2[length] = innerSubscription;
            } while (!this.c.compareAndSet(innerSubscriptionArr, innerSubscriptionArr2));
            return true;
        }

        void b(InnerSubscription<T> innerSubscription) {
            InnerSubscription<T>[] innerSubscriptionArr;
            InnerSubscription<T>[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = this.c.get();
                int length = innerSubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (innerSubscriptionArr[i3].equals(innerSubscription)) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriptionArr2 = h;
                } else {
                    InnerSubscription<T>[] innerSubscriptionArr3 = new InnerSubscription[length - 1];
                    System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr3, 0, i2);
                    System.arraycopy(innerSubscriptionArr, i2 + 1, innerSubscriptionArr3, i2, (length - i2) - 1);
                    innerSubscriptionArr2 = innerSubscriptionArr3;
                }
            } while (!this.c.compareAndSet(innerSubscriptionArr, innerSubscriptionArr2));
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.c.set(i);
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.c.get() == i;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.b) {
                return;
            }
            this.b = true;
            this.a.complete();
            for (InnerSubscription<T> innerSubscription : this.c.getAndSet(i)) {
                this.a.replay(innerSubscription);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.b) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.b = true;
            this.a.error(th);
            for (InnerSubscription<T> innerSubscription : this.c.getAndSet(i)) {
                this.a.replay(innerSubscription);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.b) {
                return;
            }
            this.a.next(t);
            for (InnerSubscription<T> innerSubscription : this.c.get()) {
                this.a.replay(innerSubscription);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this, subscription)) {
                a();
                for (InnerSubscription<T> innerSubscription : this.c.get()) {
                    this.a.replay(innerSubscription);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class ScheduledReplayBufferTask<T> implements Callable<ReplayBuffer<T>> {
        private final int bufferSize;
        private final long maxAge;
        private final Scheduler scheduler;
        private final TimeUnit unit;

        ScheduledReplayBufferTask(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.bufferSize = i;
            this.maxAge = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
        }

        @Override // java.util.concurrent.Callable
        public ReplayBuffer<T> call() {
            return new SizeAndTimeBoundReplayBuffer(this.bufferSize, this.maxAge, this.unit, this.scheduler);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final Scheduler d;
        final long e;
        final TimeUnit f;
        final int g;

        SizeAndTimeBoundReplayBuffer(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.d = scheduler;
            this.g = i;
            this.e = j;
            this.f = timeUnit;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        Node a() {
            Node node;
            Timed timed;
            long now = this.d.now(this.f) - this.e;
            Node node2 = get();
            do {
                node = node2;
                node2 = node2.get();
                if (node2 != null) {
                    timed = (Timed) node2.a;
                    if (NotificationLite.isComplete(timed.value()) || NotificationLite.isError(timed.value())) {
                        break;
                    }
                } else {
                    break;
                }
            } while (timed.time() <= now);
            return node;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        Object a(Object obj) {
            return new Timed(obj, this.d.now(this.f), this.f);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        Object b(Object obj) {
            return ((Timed) obj).value();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        void d() {
            Node node;
            long now = this.d.now(this.f) - this.e;
            Node node2 = get();
            Node node3 = node2.get();
            int i = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null) {
                    break;
                }
                int i2 = this.b;
                if (i2 <= this.g) {
                    if (((Timed) node2.a).time() > now) {
                        break;
                    }
                    i++;
                    this.b--;
                } else {
                    i++;
                    this.b = i2 - 1;
                }
                node3 = node2.get();
            }
            if (i != 0) {
                b(node);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:
        
            b(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
        
            return;
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void e() {
            /*
                r10 = this;
                io.reactivex.Scheduler r0 = r10.d
                java.util.concurrent.TimeUnit r1 = r10.f
                long r0 = r0.now(r1)
                long r2 = r10.e
                long r0 = r0 - r2
                java.lang.Object r2 = r10.get()
                io.reactivex.internal.operators.flowable.FlowableReplay$Node r2 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r2
                java.lang.Object r3 = r2.get()
                io.reactivex.internal.operators.flowable.FlowableReplay$Node r3 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r3
                r4 = 0
            L18:
                r9 = r3
                r3 = r2
                r2 = r9
                if (r2 == 0) goto L3c
                int r5 = r10.b
                r6 = 1
                if (r5 <= r6) goto L3c
                java.lang.Object r5 = r2.a
                io.reactivex.schedulers.Timed r5 = (io.reactivex.schedulers.Timed) r5
                long r7 = r5.time()
                int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r5 > 0) goto L3c
                int r4 = r4 + 1
                int r3 = r10.b
                int r3 = r3 - r6
                r10.b = r3
                java.lang.Object r3 = r2.get()
                io.reactivex.internal.operators.flowable.FlowableReplay$Node r3 = (io.reactivex.internal.operators.flowable.FlowableReplay.Node) r3
                goto L18
            L3c:
                if (r4 == 0) goto L41
                r10.b(r3)
            L41:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableReplay.SizeAndTimeBoundReplayBuffer.e():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int d;

        SizeBoundReplayBuffer(int i) {
            this.d = i;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        void d() {
            if (this.b > this.d) {
                b();
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int a;

        UnboundedReplayBuffer(int i) {
            super(i);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void complete() {
            add(NotificationLite.complete());
            this.a++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void error(Throwable th) {
            add(NotificationLite.error(th));
            this.a++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void next(T t) {
            add(NotificationLite.next(t));
            this.a++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void replay(InnerSubscription<T> innerSubscription) {
            synchronized (innerSubscription) {
                if (innerSubscription.e) {
                    innerSubscription.f = true;
                    return;
                }
                innerSubscription.e = true;
                Subscriber<? super T> subscriber = innerSubscription.b;
                while (!innerSubscription.isDisposed()) {
                    int i = this.a;
                    Integer num = (Integer) innerSubscription.a();
                    int intValue = num != null ? num.intValue() : 0;
                    long j = innerSubscription.get();
                    long j2 = j;
                    long j3 = 0;
                    while (j2 != 0 && intValue < i) {
                        Object obj = get(intValue);
                        try {
                            if (NotificationLite.accept(obj, subscriber) || innerSubscription.isDisposed()) {
                                return;
                            }
                            intValue++;
                            j2--;
                            j3++;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            innerSubscription.dispose();
                            if (NotificationLite.isError(obj) || NotificationLite.isComplete(obj)) {
                                return;
                            }
                            subscriber.onError(th);
                            return;
                        }
                    }
                    if (j3 != 0) {
                        innerSubscription.c = Integer.valueOf(intValue);
                        if (j != Long.MAX_VALUE) {
                            innerSubscription.produced(j3);
                        }
                    }
                    synchronized (innerSubscription) {
                        if (!innerSubscription.f) {
                            innerSubscription.e = false;
                            return;
                        }
                        innerSubscription.f = false;
                    }
                }
            }
        }
    }

    private FlowableReplay(Publisher<T> publisher, Flowable<T> flowable, AtomicReference<ReplaySubscriber<T>> atomicReference, Callable<? extends ReplayBuffer<T>> callable) {
        this.e = publisher;
        this.b = flowable;
        this.c = atomicReference;
        this.d = callable;
    }

    static <T> ConnectableFlowable<T> a(Flowable<T> flowable, Callable<? extends ReplayBuffer<T>> callable) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.onAssembly((ConnectableFlowable) new FlowableReplay(new ReplayPublisher(atomicReference, callable), flowable, atomicReference, callable));
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, int i) {
        return i == Integer.MAX_VALUE ? createFrom(flowable) : a(flowable, new ReplayBufferTask(i));
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return create(flowable, j, timeUnit, scheduler, Integer.MAX_VALUE);
    }

    public static <T> ConnectableFlowable<T> create(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        return a(flowable, new ScheduledReplayBufferTask(i, j, timeUnit, scheduler));
    }

    public static <T> ConnectableFlowable<T> createFrom(Flowable<? extends T> flowable) {
        return a(flowable, f);
    }

    public static <U, R> Flowable<R> multicastSelector(Callable<? extends ConnectableFlowable<U>> callable, Function<? super Flowable<U>, ? extends Publisher<R>> function) {
        return new MulticastFlowable(callable, function);
    }

    public static <T> ConnectableFlowable<T> observeOn(ConnectableFlowable<T> connectableFlowable, Scheduler scheduler) {
        return RxJavaPlugins.onAssembly((ConnectableFlowable) new ConnectableFlowableReplay(connectableFlowable, connectableFlowable.observeOn(scheduler)));
    }

    @Override // io.reactivex.flowables.ConnectableFlowable
    public void connect(Consumer<? super Disposable> consumer) {
        ReplaySubscriber<T> replaySubscriber;
        while (true) {
            replaySubscriber = this.c.get();
            if (replaySubscriber != null && !replaySubscriber.isDisposed()) {
                break;
            }
            try {
                ReplaySubscriber<T> replaySubscriber2 = new ReplaySubscriber<>(this.d.call());
                if (this.c.compareAndSet(replaySubscriber, replaySubscriber2)) {
                    replaySubscriber = replaySubscriber2;
                    break;
                }
            } finally {
                Exceptions.throwIfFatal(th);
                RuntimeException wrapOrThrow = ExceptionHelper.wrapOrThrow(th);
            }
        }
        boolean z = !replaySubscriber.d.get() && replaySubscriber.d.compareAndSet(false, true);
        try {
            consumer.accept(replaySubscriber);
            if (z) {
                this.b.subscribe((FlowableSubscriber) replaySubscriber);
            }
        } catch (Throwable th) {
            if (z) {
                replaySubscriber.d.compareAndSet(true, false);
            }
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.c.lazySet(null);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        ReplaySubscriber<T> replaySubscriber = this.c.get();
        return replaySubscriber == null || replaySubscriber.isDisposed();
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamPublisher
    public Publisher<T> source() {
        return this.b;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.e.subscribe(subscriber);
    }
}
