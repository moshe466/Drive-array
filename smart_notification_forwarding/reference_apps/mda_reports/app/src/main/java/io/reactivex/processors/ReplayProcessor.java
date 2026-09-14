package io.reactivex.processors;

import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes3.dex */
public final class ReplayProcessor<T> extends FlowableProcessor<T> {
    private static final Object[] EMPTY_ARRAY = new Object[0];
    static final ReplaySubscription[] e = new ReplaySubscription[0];
    static final ReplaySubscription[] f = new ReplaySubscription[0];
    final ReplayBuffer<T> b;
    boolean c;
    final AtomicReference<ReplaySubscription<T>[]> d = new AtomicReference<>(e);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T a;

        Node(T t) {
            this.a = t;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th);

        Throwable getError();

        @Nullable
        T getValue();

        T[] getValues(T[] tArr);

        boolean isDone();

        void next(T t);

        void replay(ReplaySubscription<T> replaySubscription);

        int size();

        void trimHead();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ReplaySubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 466549804534799122L;
        final Subscriber<? super T> a;
        final ReplayProcessor<T> b;
        Object c;
        final AtomicLong d = new AtomicLong();
        volatile boolean e;
        long f;

        ReplaySubscription(Subscriber<? super T> subscriber, ReplayProcessor<T> replayProcessor) {
            this.a = subscriber;
            this.b = replayProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.e) {
                return;
            }
            this.e = true;
            this.b.b(this);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.d, j);
                this.b.b.replay(this);
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class SizeAndTimeBoundReplayBuffer<T> implements ReplayBuffer<T> {
        final int a;
        final long b;
        final TimeUnit c;
        final Scheduler d;
        int e;
        volatile TimedNode<T> f;
        TimedNode<T> g;
        Throwable h;
        volatile boolean i;

        SizeAndTimeBoundReplayBuffer(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.a = ObjectHelper.verifyPositive(i, "maxSize");
            this.b = ObjectHelper.verifyPositive(j, "maxAge");
            this.c = (TimeUnit) ObjectHelper.requireNonNull(timeUnit, "unit is null");
            this.d = (Scheduler) ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            TimedNode<T> timedNode = new TimedNode<>(null, 0L);
            this.g = timedNode;
            this.f = timedNode;
        }

        int a(TimedNode<T> timedNode) {
            int i = 0;
            while (i != Integer.MAX_VALUE && (timedNode = timedNode.get()) != null) {
                i++;
            }
            return i;
        }

        TimedNode<T> a() {
            TimedNode<T> timedNode;
            TimedNode<T> timedNode2 = this.f;
            long now = this.d.now(this.c) - this.b;
            do {
                timedNode = timedNode2;
                timedNode2 = timedNode2.get();
                if (timedNode2 == null) {
                    break;
                }
            } while (timedNode2.b <= now);
            return timedNode;
        }

        void b() {
            int i = this.e;
            if (i > this.a) {
                this.e = i - 1;
                this.f = this.f.get();
            }
            long now = this.d.now(this.c) - this.b;
            TimedNode<T> timedNode = this.f;
            while (true) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 != null && timedNode2.b <= now) {
                    timedNode = timedNode2;
                }
            }
            this.f = timedNode;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
        
            r10.f = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void c() {
            /*
                r10 = this;
                io.reactivex.Scheduler r0 = r10.d
                java.util.concurrent.TimeUnit r1 = r10.c
                long r0 = r0.now(r1)
                long r2 = r10.b
                long r0 = r0 - r2
                io.reactivex.processors.ReplayProcessor$TimedNode<T> r2 = r10.f
            Ld:
                java.lang.Object r3 = r2.get()
                io.reactivex.processors.ReplayProcessor$TimedNode r3 = (io.reactivex.processors.ReplayProcessor.TimedNode) r3
                r4 = 0
                r6 = 0
                if (r3 != 0) goto L27
                T r0 = r2.a
                if (r0 == 0) goto L24
                io.reactivex.processors.ReplayProcessor$TimedNode r0 = new io.reactivex.processors.ReplayProcessor$TimedNode
                r0.<init>(r6, r4)
            L21:
                r10.f = r0
                goto L3e
            L24:
                r10.f = r2
                goto L3e
            L27:
                long r7 = r3.b
                int r9 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r9 <= 0) goto L3f
                T r0 = r2.a
                if (r0 == 0) goto L24
                io.reactivex.processors.ReplayProcessor$TimedNode r0 = new io.reactivex.processors.ReplayProcessor$TimedNode
                r0.<init>(r6, r4)
                java.lang.Object r1 = r2.get()
                r0.lazySet(r1)
                goto L21
            L3e:
                return
            L3f:
                r2 = r3
                goto Ld
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.processors.ReplayProcessor.SizeAndTimeBoundReplayBuffer.c():void");
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void complete() {
            c();
            this.i = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void error(Throwable th) {
            c();
            this.h = th;
            this.i = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public Throwable getError() {
            return this.h;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        @Nullable
        public T getValue() {
            TimedNode<T> timedNode = this.f;
            while (true) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    break;
                }
                timedNode = timedNode2;
            }
            if (timedNode.b < this.d.now(this.c) - this.b) {
                return null;
            }
            return timedNode.a;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public T[] getValues(T[] tArr) {
            TimedNode<T> a = a();
            int a2 = a(a);
            if (a2 != 0) {
                if (tArr.length < a2) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), a2));
                }
                for (int i = 0; i != a2; i++) {
                    a = a.get();
                    tArr[i] = a.a;
                }
                if (tArr.length > a2) {
                    tArr[a2] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public boolean isDone() {
            return this.i;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void next(T t) {
            TimedNode<T> timedNode = new TimedNode<>(t, this.d.now(this.c));
            TimedNode<T> timedNode2 = this.g;
            this.g = timedNode;
            this.e++;
            timedNode2.set(timedNode);
            b();
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void replay(ReplaySubscription<T> replaySubscription) {
            if (replaySubscription.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = replaySubscription.a;
            TimedNode<T> timedNode = (TimedNode) replaySubscription.c;
            if (timedNode == null) {
                timedNode = a();
            }
            long j = replaySubscription.f;
            int i = 1;
            do {
                long j2 = replaySubscription.d.get();
                while (j != j2) {
                    if (replaySubscription.e) {
                        replaySubscription.c = null;
                        return;
                    }
                    boolean z = this.i;
                    TimedNode<T> timedNode2 = timedNode.get();
                    boolean z2 = timedNode2 == null;
                    if (z && z2) {
                        replaySubscription.c = null;
                        replaySubscription.e = true;
                        Throwable th = this.h;
                        if (th == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th);
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.onNext(timedNode2.a);
                    j++;
                    timedNode = timedNode2;
                }
                if (j == j2) {
                    if (replaySubscription.e) {
                        replaySubscription.c = null;
                        return;
                    }
                    if (this.i && timedNode.get() == null) {
                        replaySubscription.c = null;
                        replaySubscription.e = true;
                        Throwable th2 = this.h;
                        if (th2 == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th2);
                            return;
                        }
                    }
                }
                replaySubscription.c = timedNode;
                replaySubscription.f = j;
                i = replaySubscription.addAndGet(-i);
            } while (i != 0);
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public int size() {
            return a(a());
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void trimHead() {
            if (this.f.a != null) {
                TimedNode<T> timedNode = new TimedNode<>(null, 0L);
                timedNode.lazySet(this.f.get());
                this.f = timedNode;
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class SizeBoundReplayBuffer<T> implements ReplayBuffer<T> {
        final int a;
        int b;
        volatile Node<T> c;
        Node<T> d;
        Throwable e;
        volatile boolean f;

        SizeBoundReplayBuffer(int i) {
            this.a = ObjectHelper.verifyPositive(i, "maxSize");
            Node<T> node = new Node<>(null);
            this.d = node;
            this.c = node;
        }

        void a() {
            int i = this.b;
            if (i > this.a) {
                this.b = i - 1;
                this.c = this.c.get();
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void complete() {
            trimHead();
            this.f = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void error(Throwable th) {
            this.e = th;
            trimHead();
            this.f = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public Throwable getError() {
            return this.e;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public T getValue() {
            Node<T> node = this.c;
            while (true) {
                Node<T> node2 = node.get();
                if (node2 == null) {
                    return node.a;
                }
                node = node2;
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public T[] getValues(T[] tArr) {
            Node<T> node = this.c;
            Node<T> node2 = node;
            int i = 0;
            while (true) {
                node2 = node2.get();
                if (node2 == null) {
                    break;
                }
                i++;
            }
            if (tArr.length < i) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i));
            }
            for (int i2 = 0; i2 < i; i2++) {
                node = node.get();
                tArr[i2] = node.a;
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public boolean isDone() {
            return this.f;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void next(T t) {
            Node<T> node = new Node<>(t);
            Node<T> node2 = this.d;
            this.d = node;
            this.b++;
            node2.set(node);
            a();
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void replay(ReplaySubscription<T> replaySubscription) {
            if (replaySubscription.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = replaySubscription.a;
            Node<T> node = (Node) replaySubscription.c;
            if (node == null) {
                node = this.c;
            }
            long j = replaySubscription.f;
            int i = 1;
            do {
                long j2 = replaySubscription.d.get();
                while (j != j2) {
                    if (replaySubscription.e) {
                        replaySubscription.c = null;
                        return;
                    }
                    boolean z = this.f;
                    Node<T> node2 = node.get();
                    boolean z2 = node2 == null;
                    if (z && z2) {
                        replaySubscription.c = null;
                        replaySubscription.e = true;
                        Throwable th = this.e;
                        if (th == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th);
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.onNext(node2.a);
                    j++;
                    node = node2;
                }
                if (j == j2) {
                    if (replaySubscription.e) {
                        replaySubscription.c = null;
                        return;
                    }
                    if (this.f && node.get() == null) {
                        replaySubscription.c = null;
                        replaySubscription.e = true;
                        Throwable th2 = this.e;
                        if (th2 == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th2);
                            return;
                        }
                    }
                }
                replaySubscription.c = node;
                replaySubscription.f = j;
                i = replaySubscription.addAndGet(-i);
            } while (i != 0);
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public int size() {
            Node<T> node = this.c;
            int i = 0;
            while (i != Integer.MAX_VALUE && (node = node.get()) != null) {
                i++;
            }
            return i;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void trimHead() {
            if (this.c.a != null) {
                Node<T> node = new Node<>(null);
                node.lazySet(this.c.get());
                this.c = node;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T a;
        final long b;

        TimedNode(T t, long j) {
            this.a = t;
            this.b = j;
        }
    }

    /* loaded from: classes3.dex */
    static final class UnboundedReplayBuffer<T> implements ReplayBuffer<T> {
        final List<T> a;
        Throwable b;
        volatile boolean c;
        volatile int d;

        UnboundedReplayBuffer(int i) {
            this.a = new ArrayList(ObjectHelper.verifyPositive(i, "capacityHint"));
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void complete() {
            this.c = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void error(Throwable th) {
            this.b = th;
            this.c = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public Throwable getError() {
            return this.b;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        @Nullable
        public T getValue() {
            int i = this.d;
            if (i == 0) {
                return null;
            }
            return this.a.get(i - 1);
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public T[] getValues(T[] tArr) {
            int i = this.d;
            if (i == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            List<T> list = this.a;
            if (tArr.length < i) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i));
            }
            for (int i2 = 0; i2 < i; i2++) {
                tArr[i2] = list.get(i2);
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public boolean isDone() {
            return this.c;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void next(T t) {
            this.a.add(t);
            this.d++;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void replay(ReplaySubscription<T> replaySubscription) {
            if (replaySubscription.getAndIncrement() != 0) {
                return;
            }
            List<T> list = this.a;
            Subscriber<? super T> subscriber = replaySubscription.a;
            Integer num = (Integer) replaySubscription.c;
            int i = 0;
            if (num != null) {
                i = num.intValue();
            } else {
                replaySubscription.c = 0;
            }
            long j = replaySubscription.f;
            int i2 = 1;
            do {
                long j2 = replaySubscription.d.get();
                while (j != j2) {
                    if (replaySubscription.e) {
                        replaySubscription.c = null;
                        return;
                    }
                    boolean z = this.c;
                    int i3 = this.d;
                    if (z && i == i3) {
                        replaySubscription.c = null;
                        replaySubscription.e = true;
                        Throwable th = this.b;
                        if (th == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th);
                            return;
                        }
                    }
                    if (i == i3) {
                        break;
                    }
                    subscriber.onNext(list.get(i));
                    i++;
                    j++;
                }
                if (j == j2) {
                    if (replaySubscription.e) {
                        replaySubscription.c = null;
                        return;
                    }
                    boolean z2 = this.c;
                    int i4 = this.d;
                    if (z2 && i == i4) {
                        replaySubscription.c = null;
                        replaySubscription.e = true;
                        Throwable th2 = this.b;
                        if (th2 == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th2);
                            return;
                        }
                    }
                }
                replaySubscription.c = Integer.valueOf(i);
                replaySubscription.f = j;
                i2 = replaySubscription.addAndGet(-i2);
            } while (i2 != 0);
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public int size() {
            return this.d;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void trimHead() {
        }
    }

    ReplayProcessor(ReplayBuffer<T> replayBuffer) {
        this.b = replayBuffer;
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayProcessor<T> create() {
        return new ReplayProcessor<>(new UnboundedReplayBuffer(16));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayProcessor<T> create(int i) {
        return new ReplayProcessor<>(new UnboundedReplayBuffer(i));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayProcessor<T> createWithSize(int i) {
        return new ReplayProcessor<>(new SizeBoundReplayBuffer(i));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayProcessor<T> createWithTime(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new ReplayProcessor<>(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, j, timeUnit, scheduler));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayProcessor<T> createWithTimeAndSize(long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        return new ReplayProcessor<>(new SizeAndTimeBoundReplayBuffer(i, j, timeUnit, scheduler));
    }

    boolean a(ReplaySubscription<T> replaySubscription) {
        ReplaySubscription<T>[] replaySubscriptionArr;
        ReplaySubscription<T>[] replaySubscriptionArr2;
        do {
            replaySubscriptionArr = this.d.get();
            if (replaySubscriptionArr == f) {
                return false;
            }
            int length = replaySubscriptionArr.length;
            replaySubscriptionArr2 = new ReplaySubscription[length + 1];
            System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr2, 0, length);
            replaySubscriptionArr2[length] = replaySubscription;
        } while (!this.d.compareAndSet(replaySubscriptionArr, replaySubscriptionArr2));
        return true;
    }

    void b(ReplaySubscription<T> replaySubscription) {
        ReplaySubscription<T>[] replaySubscriptionArr;
        ReplaySubscription<T>[] replaySubscriptionArr2;
        do {
            replaySubscriptionArr = this.d.get();
            if (replaySubscriptionArr == f || replaySubscriptionArr == e) {
                return;
            }
            int length = replaySubscriptionArr.length;
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (replaySubscriptionArr[i2] == replaySubscription) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                replaySubscriptionArr2 = e;
            } else {
                ReplaySubscription<T>[] replaySubscriptionArr3 = new ReplaySubscription[length - 1];
                System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr3, 0, i);
                System.arraycopy(replaySubscriptionArr, i + 1, replaySubscriptionArr3, i, (length - i) - 1);
                replaySubscriptionArr2 = replaySubscriptionArr3;
            }
        } while (!this.d.compareAndSet(replaySubscriptionArr, replaySubscriptionArr2));
    }

    @Experimental
    public void cleanupBuffer() {
        this.b.trimHead();
    }

    @Override // io.reactivex.processors.FlowableProcessor
    @Nullable
    public Throwable getThrowable() {
        ReplayBuffer<T> replayBuffer = this.b;
        if (replayBuffer.isDone()) {
            return replayBuffer.getError();
        }
        return null;
    }

    public T getValue() {
        return this.b.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object[] getValues() {
        Object[] values = getValues(EMPTY_ARRAY);
        return values == EMPTY_ARRAY ? new Object[0] : values;
    }

    public T[] getValues(T[] tArr) {
        return this.b.getValues(tArr);
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        ReplayBuffer<T> replayBuffer = this.b;
        return replayBuffer.isDone() && replayBuffer.getError() == null;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        return this.d.get().length != 0;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        ReplayBuffer<T> replayBuffer = this.b;
        return replayBuffer.isDone() && replayBuffer.getError() != null;
    }

    public boolean hasValue() {
        return this.b.size() != 0;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.c) {
            return;
        }
        this.c = true;
        ReplayBuffer<T> replayBuffer = this.b;
        replayBuffer.complete();
        for (ReplaySubscription<T> replaySubscription : this.d.getAndSet(f)) {
            replayBuffer.replay(replaySubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.c) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.c = true;
        ReplayBuffer<T> replayBuffer = this.b;
        replayBuffer.error(th);
        for (ReplaySubscription<T> replaySubscription : this.d.getAndSet(f)) {
            replayBuffer.replay(replaySubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.c) {
            return;
        }
        ReplayBuffer<T> replayBuffer = this.b;
        replayBuffer.next(t);
        for (ReplaySubscription<T> replaySubscription : this.d.get()) {
            replayBuffer.replay(replaySubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (this.c) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        ReplaySubscription<T> replaySubscription = new ReplaySubscription<>(subscriber, this);
        subscriber.onSubscribe(replaySubscription);
        if (a(replaySubscription) && replaySubscription.e) {
            b(replaySubscription);
        } else {
            this.b.replay(replaySubscription);
        }
    }
}
