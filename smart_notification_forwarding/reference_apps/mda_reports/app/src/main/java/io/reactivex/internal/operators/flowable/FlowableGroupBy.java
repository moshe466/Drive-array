package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.GroupedFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.EmptyComponent;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableGroupBy<T, K, V> extends AbstractFlowableWithUpstream<T, GroupedFlowable<K, V>> {
    final Function<? super T, ? extends K> c;
    final Function<? super T, ? extends V> d;
    final int e;
    final boolean f;
    final Function<? super Consumer<Object>, ? extends Map<K, Object>> g;

    /* loaded from: classes2.dex */
    static final class EvictionAction<K, V> implements Consumer<GroupedUnicast<K, V>> {
        final Queue<GroupedUnicast<K, V>> a;

        EvictionAction(Queue<GroupedUnicast<K, V>> queue) {
            this.a = queue;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(GroupedUnicast<K, V> groupedUnicast) {
            this.a.offer(groupedUnicast);
        }
    }

    /* loaded from: classes2.dex */
    public static final class GroupBySubscriber<T, K, V> extends BasicIntQueueSubscription<GroupedFlowable<K, V>> implements FlowableSubscriber<T> {
        static final Object p = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        final Subscriber<? super GroupedFlowable<K, V>> a;
        final Function<? super T, ? extends K> b;
        final Function<? super T, ? extends V> c;
        final int d;
        final boolean e;
        final Map<Object, GroupedUnicast<K, V>> f;
        final SpscLinkedArrayQueue<GroupedFlowable<K, V>> g;
        final Queue<GroupedUnicast<K, V>> h;
        Subscription i;
        final AtomicBoolean j = new AtomicBoolean();
        final AtomicLong k = new AtomicLong();
        final AtomicInteger l = new AtomicInteger(1);
        Throwable m;
        volatile boolean n;
        boolean o;

        public GroupBySubscriber(Subscriber<? super GroupedFlowable<K, V>> subscriber, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i, boolean z, Map<Object, GroupedUnicast<K, V>> map, Queue<GroupedUnicast<K, V>> queue) {
            this.a = subscriber;
            this.b = function;
            this.c = function2;
            this.d = i;
            this.e = z;
            this.f = map;
            this.h = queue;
            this.g = new SpscLinkedArrayQueue<>(i);
        }

        void a() {
            Throwable th;
            SpscLinkedArrayQueue<GroupedFlowable<K, V>> spscLinkedArrayQueue = this.g;
            Subscriber<? super GroupedFlowable<K, V>> subscriber = this.a;
            int i = 1;
            while (!this.j.get()) {
                boolean z = this.n;
                if (z && !this.e && (th = this.m) != null) {
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(th);
                    return;
                }
                subscriber.onNext(null);
                if (z) {
                    Throwable th2 = this.m;
                    if (th2 != null) {
                        subscriber.onError(th2);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
            spscLinkedArrayQueue.clear();
        }

        boolean a(boolean z, boolean z2, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            if (this.j.get()) {
                spscLinkedArrayQueue.clear();
                return true;
            }
            if (this.e) {
                if (!z || !z2) {
                    return false;
                }
                Throwable th = this.m;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th2 = this.m;
            if (th2 != null) {
                spscLinkedArrayQueue.clear();
                subscriber.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            subscriber.onComplete();
            return true;
        }

        void b() {
            SpscLinkedArrayQueue<GroupedFlowable<K, V>> spscLinkedArrayQueue = this.g;
            Subscriber<? super GroupedFlowable<K, V>> subscriber = this.a;
            int i = 1;
            do {
                long j = this.k.get();
                long j2 = 0;
                while (j2 != j) {
                    boolean z = this.n;
                    GroupedFlowable<K, V> poll = spscLinkedArrayQueue.poll();
                    boolean z2 = poll == null;
                    if (a(z, z2, subscriber, spscLinkedArrayQueue)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.onNext(poll);
                    j2++;
                }
                if (j2 == j && a(this.n, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                    return;
                }
                if (j2 != 0) {
                    if (j != Long.MAX_VALUE) {
                        this.k.addAndGet(-j2);
                    }
                    this.i.request(j2);
                }
                i = addAndGet(-i);
            } while (i != 0);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.j.compareAndSet(false, true) && this.l.decrementAndGet() == 0) {
                this.i.cancel();
            }
        }

        public void cancel(K k) {
            if (k == null) {
                k = (K) p;
            }
            this.f.remove(k);
            if (this.l.decrementAndGet() == 0) {
                this.i.cancel();
                if (getAndIncrement() == 0) {
                    this.g.clear();
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.g.clear();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.o) {
                a();
            } else {
                b();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.g.isEmpty();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.n) {
                return;
            }
            Iterator<GroupedUnicast<K, V>> it = this.f.values().iterator();
            while (it.hasNext()) {
                it.next().onComplete();
            }
            this.f.clear();
            Queue<GroupedUnicast<K, V>> queue = this.h;
            if (queue != null) {
                queue.clear();
            }
            this.n = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.n) {
                RxJavaPlugins.onError(th);
                return;
            }
            Iterator<GroupedUnicast<K, V>> it = this.f.values().iterator();
            while (it.hasNext()) {
                it.next().onError(th);
            }
            this.f.clear();
            Queue<GroupedUnicast<K, V>> queue = this.h;
            if (queue != null) {
                queue.clear();
            }
            this.m = th;
            this.n = true;
            drain();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.n) {
                return;
            }
            SpscLinkedArrayQueue<GroupedFlowable<K, V>> spscLinkedArrayQueue = this.g;
            try {
                K apply = this.b.apply(t);
                boolean z = false;
                Object obj = apply != null ? apply : p;
                GroupedUnicast<K, V> groupedUnicast = this.f.get(obj);
                GroupedUnicast groupedUnicast2 = groupedUnicast;
                if (groupedUnicast == null) {
                    if (this.j.get()) {
                        return;
                    }
                    GroupedUnicast createWith = GroupedUnicast.createWith(apply, this.d, this, this.e);
                    this.f.put(obj, createWith);
                    this.l.getAndIncrement();
                    z = true;
                    groupedUnicast2 = createWith;
                }
                groupedUnicast2.onNext(ObjectHelper.requireNonNull(this.c.apply(t), "The valueSelector returned null"));
                if (this.h != null) {
                    while (true) {
                        GroupedUnicast<K, V> poll = this.h.poll();
                        if (poll == null) {
                            break;
                        } else {
                            poll.onComplete();
                        }
                    }
                }
                if (z) {
                    spscLinkedArrayQueue.offer(groupedUnicast2);
                    drain();
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.i.cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.i, subscription)) {
                this.i = subscription;
                this.a.onSubscribe(this);
                subscription.request(this.d);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public GroupedFlowable<K, V> poll() {
            return this.g.poll();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.k, j);
                drain();
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.o = true;
            return 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class GroupedUnicast<K, T> extends GroupedFlowable<K, T> {
        final State<T, K> c;

        protected GroupedUnicast(K k, State<T, K> state) {
            super(k);
            this.c = state;
        }

        public static <T, K> GroupedUnicast<K, T> createWith(K k, int i, GroupBySubscriber<?, K, T> groupBySubscriber, boolean z) {
            return new GroupedUnicast<>(k, new State(i, groupBySubscriber, k, z));
        }

        public void onComplete() {
            this.c.onComplete();
        }

        public void onError(Throwable th) {
            this.c.onError(th);
        }

        public void onNext(T t) {
            this.c.onNext(t);
        }

        @Override // io.reactivex.Flowable
        protected void subscribeActual(Subscriber<? super T> subscriber) {
            this.c.subscribe(subscriber);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class State<T, K> extends BasicIntQueueSubscription<T> implements Publisher<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final K a;
        final SpscLinkedArrayQueue<T> b;
        final GroupBySubscriber<?, K, T> c;
        final boolean d;
        volatile boolean f;
        Throwable g;
        boolean k;
        int l;
        final AtomicLong e = new AtomicLong();
        final AtomicBoolean h = new AtomicBoolean();
        final AtomicReference<Subscriber<? super T>> i = new AtomicReference<>();
        final AtomicBoolean j = new AtomicBoolean();

        State(int i, GroupBySubscriber<?, K, T> groupBySubscriber, K k, boolean z) {
            this.b = new SpscLinkedArrayQueue<>(i);
            this.c = groupBySubscriber;
            this.a = k;
            this.d = z;
        }

        void a() {
            Throwable th;
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.b;
            Subscriber<? super T> subscriber = this.i.get();
            int i = 1;
            while (true) {
                if (subscriber != null) {
                    if (this.h.get()) {
                        spscLinkedArrayQueue.clear();
                        return;
                    }
                    boolean z = this.f;
                    if (z && !this.d && (th = this.g) != null) {
                        spscLinkedArrayQueue.clear();
                        subscriber.onError(th);
                        return;
                    }
                    subscriber.onNext(null);
                    if (z) {
                        Throwable th2 = this.g;
                        if (th2 != null) {
                            subscriber.onError(th2);
                            return;
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
                if (subscriber == null) {
                    subscriber = this.i.get();
                }
            }
        }

        boolean a(boolean z, boolean z2, Subscriber<? super T> subscriber, boolean z3) {
            if (this.h.get()) {
                this.b.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (z3) {
                if (!z2) {
                    return false;
                }
                Throwable th = this.g;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
            Throwable th2 = this.g;
            if (th2 != null) {
                this.b.clear();
                subscriber.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            subscriber.onComplete();
            return true;
        }

        void b() {
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.b;
            boolean z = this.d;
            Subscriber<? super T> subscriber = this.i.get();
            int i = 1;
            while (true) {
                if (subscriber != null) {
                    long j = this.e.get();
                    long j2 = 0;
                    while (j2 != j) {
                        boolean z2 = this.f;
                        T poll = spscLinkedArrayQueue.poll();
                        boolean z3 = poll == null;
                        if (a(z2, z3, subscriber, z)) {
                            return;
                        }
                        if (z3) {
                            break;
                        }
                        subscriber.onNext(poll);
                        j2++;
                    }
                    if (j2 == j && a(this.f, spscLinkedArrayQueue.isEmpty(), subscriber, z)) {
                        return;
                    }
                    if (j2 != 0) {
                        if (j != Long.MAX_VALUE) {
                            this.e.addAndGet(-j2);
                        }
                        this.c.i.request(j2);
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
                if (subscriber == null) {
                    subscriber = this.i.get();
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.h.compareAndSet(false, true)) {
                this.c.cancel(this.a);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.b.clear();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.k) {
                a();
            } else {
                b();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.b.isEmpty();
        }

        public void onComplete() {
            this.f = true;
            drain();
        }

        public void onError(Throwable th) {
            this.g = th;
            this.f = true;
            drain();
        }

        public void onNext(T t) {
            this.b.offer(t);
            drain();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            T poll = this.b.poll();
            if (poll != null) {
                this.l++;
                return poll;
            }
            int i = this.l;
            if (i == 0) {
                return null;
            }
            this.l = 0;
            this.c.i.request(i);
            return null;
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
            if ((i & 2) == 0) {
                return 0;
            }
            this.k = true;
            return 2;
        }

        @Override // org.reactivestreams.Publisher
        public void subscribe(Subscriber<? super T> subscriber) {
            if (!this.j.compareAndSet(false, true)) {
                EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), subscriber);
                return;
            }
            subscriber.onSubscribe(this);
            this.i.lazySet(subscriber);
            drain();
        }
    }

    public FlowableGroupBy(Flowable<T> flowable, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i, boolean z, Function<? super Consumer<Object>, ? extends Map<K, Object>> function3) {
        super(flowable);
        this.c = function;
        this.d = function2;
        this.e = i;
        this.f = z;
        this.g = function3;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super GroupedFlowable<K, V>> subscriber) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        Map<K, Object> apply;
        try {
            if (this.g == null) {
                concurrentLinkedQueue = null;
                apply = new ConcurrentHashMap<>();
            } else {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                apply = this.g.apply(new EvictionAction(concurrentLinkedQueue));
            }
            this.b.subscribe((FlowableSubscriber) new GroupBySubscriber(subscriber, this.c, this.d, this.e, this.f, apply, concurrentLinkedQueue));
        } catch (Exception e) {
            Exceptions.throwIfFatal(e);
            subscriber.onSubscribe(EmptyComponent.INSTANCE);
            subscriber.onError(e);
        }
    }
}
