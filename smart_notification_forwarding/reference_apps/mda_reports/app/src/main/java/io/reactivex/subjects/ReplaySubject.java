package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ReplaySubject<T> extends Subject<T> {
    final ReplayBuffer<T> a;
    final AtomicReference<ReplayDisposable<T>[]> b = new AtomicReference<>(d);
    boolean c;
    static final ReplayDisposable[] d = new ReplayDisposable[0];
    static final ReplayDisposable[] e = new ReplayDisposable[0];
    private static final Object[] EMPTY_ARRAY = new Object[0];

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
        void add(T t);

        void addFinal(Object obj);

        boolean compareAndSet(Object obj, Object obj2);

        Object get();

        @Nullable
        T getValue();

        T[] getValues(T[] tArr);

        void replay(ReplayDisposable<T> replayDisposable);

        int size();

        void trimHead();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ReplayDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 466549804534799122L;
        final Observer<? super T> a;
        final ReplaySubject<T> b;
        Object c;
        volatile boolean d;

        ReplayDisposable(Observer<? super T> observer, ReplaySubject<T> replaySubject) {
            this.a = observer;
            this.b = replaySubject;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.d) {
                return;
            }
            this.d = true;
            this.b.b(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d;
        }
    }

    /* loaded from: classes3.dex */
    static final class SizeAndTimeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = -8056260896137901749L;
        final int a;
        final long b;
        final TimeUnit c;
        final Scheduler d;
        int e;
        volatile TimedNode<Object> f;
        TimedNode<Object> g;
        volatile boolean h;

        SizeAndTimeBoundReplayBuffer(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.a = ObjectHelper.verifyPositive(i, "maxSize");
            this.b = ObjectHelper.verifyPositive(j, "maxAge");
            this.c = (TimeUnit) ObjectHelper.requireNonNull(timeUnit, "unit is null");
            this.d = (Scheduler) ObjectHelper.requireNonNull(scheduler, "scheduler is null");
            TimedNode<Object> timedNode = new TimedNode<>(null, 0L);
            this.g = timedNode;
            this.f = timedNode;
        }

        int a(TimedNode<Object> timedNode) {
            int i = 0;
            while (i != Integer.MAX_VALUE) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    Object obj = timedNode.a;
                    return (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? i - 1 : i;
                }
                i++;
                timedNode = timedNode2;
            }
            return i;
        }

        TimedNode<Object> a() {
            TimedNode<Object> timedNode;
            TimedNode<Object> timedNode2 = this.f;
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

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void add(T t) {
            TimedNode<Object> timedNode = new TimedNode<>(t, this.d.now(this.c));
            TimedNode<Object> timedNode2 = this.g;
            this.g = timedNode;
            this.e++;
            timedNode2.set(timedNode);
            b();
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void addFinal(Object obj) {
            TimedNode<Object> timedNode = new TimedNode<>(obj, Long.MAX_VALUE);
            TimedNode<Object> timedNode2 = this.g;
            this.g = timedNode;
            this.e++;
            timedNode2.lazySet(timedNode);
            c();
            this.h = true;
        }

        void b() {
            int i = this.e;
            if (i > this.a) {
                this.e = i - 1;
                this.f = this.f.get();
            }
            long now = this.d.now(this.c) - this.b;
            TimedNode<Object> timedNode = this.f;
            while (true) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 != null && timedNode2.b <= now) {
                    timedNode = timedNode2;
                }
            }
            this.f = timedNode;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x002f, code lost:
        
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
                io.reactivex.subjects.ReplaySubject$TimedNode<java.lang.Object> r2 = r10.f
            Ld:
                java.lang.Object r3 = r2.get()
                io.reactivex.subjects.ReplaySubject$TimedNode r3 = (io.reactivex.subjects.ReplaySubject.TimedNode) r3
                java.lang.Object r4 = r3.get()
                r5 = 0
                r7 = 0
                if (r4 != 0) goto L32
                T r0 = r2.a
                if (r0 == 0) goto L2f
                io.reactivex.subjects.ReplaySubject$TimedNode r0 = new io.reactivex.subjects.ReplaySubject$TimedNode
                r0.<init>(r7, r5)
            L25:
                java.lang.Object r1 = r2.get()
                r0.lazySet(r1)
                r10.f = r0
                goto L42
            L2f:
                r10.f = r2
                goto L42
            L32:
                long r8 = r3.b
                int r4 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r4 <= 0) goto L43
                T r0 = r2.a
                if (r0 == 0) goto L2f
                io.reactivex.subjects.ReplaySubject$TimedNode r0 = new io.reactivex.subjects.ReplaySubject$TimedNode
                r0.<init>(r7, r5)
                goto L25
            L42:
                return
            L43:
                r2 = r3
                goto Ld
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.ReplaySubject.SizeAndTimeBoundReplayBuffer.c():void");
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        @Nullable
        public T getValue() {
            T t;
            TimedNode<Object> timedNode = this.f;
            TimedNode<Object> timedNode2 = null;
            while (true) {
                TimedNode<T> timedNode3 = timedNode.get();
                if (timedNode3 == null) {
                    break;
                }
                timedNode2 = timedNode;
                timedNode = timedNode3;
            }
            if (timedNode.b >= this.d.now(this.c) - this.b && (t = (T) timedNode.a) != null) {
                return (NotificationLite.isComplete(t) || NotificationLite.isError(t)) ? (T) timedNode2.a : t;
            }
            return null;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
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

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void replay(ReplayDisposable<T> replayDisposable) {
            if (replayDisposable.getAndIncrement() != 0) {
                return;
            }
            Observer<? super T> observer = replayDisposable.a;
            TimedNode<Object> timedNode = (TimedNode) replayDisposable.c;
            if (timedNode == null) {
                timedNode = a();
            }
            int i = 1;
            while (!replayDisposable.d) {
                while (!replayDisposable.d) {
                    TimedNode<T> timedNode2 = timedNode.get();
                    if (timedNode2 != null) {
                        T t = timedNode2.a;
                        if (this.h && timedNode2.get() == null) {
                            if (NotificationLite.isComplete(t)) {
                                observer.onComplete();
                            } else {
                                observer.onError(NotificationLite.getError(t));
                            }
                            replayDisposable.c = null;
                            replayDisposable.d = true;
                            return;
                        }
                        observer.onNext(t);
                        timedNode = timedNode2;
                    } else if (timedNode.get() == null) {
                        replayDisposable.c = timedNode;
                        i = replayDisposable.addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    }
                }
                replayDisposable.c = null;
                return;
            }
            replayDisposable.c = null;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            return a(a());
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void trimHead() {
            TimedNode<Object> timedNode = this.f;
            if (timedNode.a != null) {
                TimedNode<Object> timedNode2 = new TimedNode<>(null, 0L);
                timedNode2.lazySet(timedNode.get());
                this.f = timedNode2;
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class SizeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 1107649250281456395L;
        final int a;
        int b;
        volatile Node<Object> c;
        Node<Object> d;
        volatile boolean e;

        SizeBoundReplayBuffer(int i) {
            this.a = ObjectHelper.verifyPositive(i, "maxSize");
            Node<Object> node = new Node<>(null);
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

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void add(T t) {
            Node<Object> node = new Node<>(t);
            Node<Object> node2 = this.d;
            this.d = node;
            this.b++;
            node2.set(node);
            a();
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void addFinal(Object obj) {
            Node<Object> node = new Node<>(obj);
            Node<Object> node2 = this.d;
            this.d = node;
            this.b++;
            node2.lazySet(node);
            trimHead();
            this.e = true;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        @Nullable
        public T getValue() {
            Node<Object> node = this.c;
            Node<Object> node2 = null;
            while (true) {
                Node<T> node3 = node.get();
                if (node3 == null) {
                    break;
                }
                node2 = node;
                node = node3;
            }
            T t = (T) node.a;
            if (t == null) {
                return null;
            }
            return (NotificationLite.isComplete(t) || NotificationLite.isError(t)) ? (T) node2.a : t;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public T[] getValues(T[] tArr) {
            Node<T> node = this.c;
            int size = size();
            if (size != 0) {
                if (tArr.length < size) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
                }
                for (int i = 0; i != size; i++) {
                    node = node.get();
                    tArr[i] = node.a;
                }
                if (tArr.length > size) {
                    tArr[size] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void replay(ReplayDisposable<T> replayDisposable) {
            if (replayDisposable.getAndIncrement() != 0) {
                return;
            }
            Observer<? super T> observer = replayDisposable.a;
            Node<Object> node = (Node) replayDisposable.c;
            if (node == null) {
                node = this.c;
            }
            int i = 1;
            while (!replayDisposable.d) {
                Node<T> node2 = node.get();
                if (node2 != null) {
                    T t = node2.a;
                    if (this.e && node2.get() == null) {
                        if (NotificationLite.isComplete(t)) {
                            observer.onComplete();
                        } else {
                            observer.onError(NotificationLite.getError(t));
                        }
                        replayDisposable.c = null;
                        replayDisposable.d = true;
                        return;
                    }
                    observer.onNext(t);
                    node = node2;
                } else if (node.get() != null) {
                    continue;
                } else {
                    replayDisposable.c = node;
                    i = replayDisposable.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
            replayDisposable.c = null;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            Node<Object> node = this.c;
            int i = 0;
            while (i != Integer.MAX_VALUE) {
                Node<T> node2 = node.get();
                if (node2 == null) {
                    Object obj = node.a;
                    return (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? i - 1 : i;
                }
                i++;
                node = node2;
            }
            return i;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void trimHead() {
            Node<Object> node = this.c;
            if (node.a != null) {
                Node<Object> node2 = new Node<>(null);
                node2.lazySet(node.get());
                this.c = node2;
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
    static final class UnboundedReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = -733876083048047795L;
        final List<Object> a;
        volatile boolean b;
        volatile int c;

        UnboundedReplayBuffer(int i) {
            this.a = new ArrayList(ObjectHelper.verifyPositive(i, "capacityHint"));
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void add(T t) {
            this.a.add(t);
            this.c++;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void addFinal(Object obj) {
            this.a.add(obj);
            trimHead();
            this.c++;
            this.b = true;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        @Nullable
        public T getValue() {
            int i = this.c;
            if (i == 0) {
                return null;
            }
            List<Object> list = this.a;
            T t = (T) list.get(i - 1);
            if (!NotificationLite.isComplete(t) && !NotificationLite.isError(t)) {
                return t;
            }
            if (i == 1) {
                return null;
            }
            return (T) list.get(i - 2);
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public T[] getValues(T[] tArr) {
            int i = this.c;
            if (i == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            List<Object> list = this.a;
            Object obj = list.get(i - 1);
            if ((NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) && i - 1 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
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

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void replay(ReplayDisposable<T> replayDisposable) {
            int i;
            if (replayDisposable.getAndIncrement() != 0) {
                return;
            }
            List<Object> list = this.a;
            Observer<? super T> observer = replayDisposable.a;
            Integer num = (Integer) replayDisposable.c;
            int i2 = 0;
            if (num != null) {
                i2 = num.intValue();
            } else {
                replayDisposable.c = 0;
            }
            int i3 = 1;
            while (!replayDisposable.d) {
                int i4 = this.c;
                while (i4 != i2) {
                    if (replayDisposable.d) {
                        replayDisposable.c = null;
                        return;
                    }
                    Object obj = list.get(i2);
                    if (this.b && (i = i2 + 1) == i4 && i == (i4 = this.c)) {
                        if (NotificationLite.isComplete(obj)) {
                            observer.onComplete();
                        } else {
                            observer.onError(NotificationLite.getError(obj));
                        }
                        replayDisposable.c = null;
                        replayDisposable.d = true;
                        return;
                    }
                    observer.onNext(obj);
                    i2++;
                }
                if (i2 == this.c) {
                    replayDisposable.c = Integer.valueOf(i2);
                    i3 = replayDisposable.addAndGet(-i3);
                    if (i3 == 0) {
                        return;
                    }
                }
            }
            replayDisposable.c = null;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            int i = this.c;
            if (i == 0) {
                return 0;
            }
            int i2 = i - 1;
            Object obj = this.a.get(i2);
            return (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? i2 : i;
        }

        @Override // io.reactivex.subjects.ReplaySubject.ReplayBuffer
        public void trimHead() {
        }
    }

    ReplaySubject(ReplayBuffer<T> replayBuffer) {
        this.a = replayBuffer;
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplaySubject<T> create() {
        return new ReplaySubject<>(new UnboundedReplayBuffer(16));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplaySubject<T> create(int i) {
        return new ReplaySubject<>(new UnboundedReplayBuffer(i));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplaySubject<T> createWithSize(int i) {
        return new ReplaySubject<>(new SizeBoundReplayBuffer(i));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplaySubject<T> createWithTime(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new ReplaySubject<>(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, j, timeUnit, scheduler));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplaySubject<T> createWithTimeAndSize(long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        return new ReplaySubject<>(new SizeAndTimeBoundReplayBuffer(i, j, timeUnit, scheduler));
    }

    boolean a(ReplayDisposable<T> replayDisposable) {
        ReplayDisposable<T>[] replayDisposableArr;
        ReplayDisposable<T>[] replayDisposableArr2;
        do {
            replayDisposableArr = this.b.get();
            if (replayDisposableArr == e) {
                return false;
            }
            int length = replayDisposableArr.length;
            replayDisposableArr2 = new ReplayDisposable[length + 1];
            System.arraycopy(replayDisposableArr, 0, replayDisposableArr2, 0, length);
            replayDisposableArr2[length] = replayDisposable;
        } while (!this.b.compareAndSet(replayDisposableArr, replayDisposableArr2));
        return true;
    }

    ReplayDisposable<T>[] a(Object obj) {
        return this.a.compareAndSet(null, obj) ? this.b.getAndSet(e) : e;
    }

    void b(ReplayDisposable<T> replayDisposable) {
        ReplayDisposable<T>[] replayDisposableArr;
        ReplayDisposable<T>[] replayDisposableArr2;
        do {
            replayDisposableArr = this.b.get();
            if (replayDisposableArr == e || replayDisposableArr == d) {
                return;
            }
            int length = replayDisposableArr.length;
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (replayDisposableArr[i2] == replayDisposable) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                replayDisposableArr2 = d;
            } else {
                ReplayDisposable<T>[] replayDisposableArr3 = new ReplayDisposable[length - 1];
                System.arraycopy(replayDisposableArr, 0, replayDisposableArr3, 0, i);
                System.arraycopy(replayDisposableArr, i + 1, replayDisposableArr3, i, (length - i) - 1);
                replayDisposableArr2 = replayDisposableArr3;
            }
        } while (!this.b.compareAndSet(replayDisposableArr, replayDisposableArr2));
    }

    @Experimental
    public void cleanupBuffer() {
        this.a.trimHead();
    }

    @Override // io.reactivex.subjects.Subject
    @Nullable
    public Throwable getThrowable() {
        Object obj = this.a.get();
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    @Nullable
    public T getValue() {
        return this.a.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object[] getValues() {
        Object[] values = getValues(EMPTY_ARRAY);
        return values == EMPTY_ARRAY ? new Object[0] : values;
    }

    public T[] getValues(T[] tArr) {
        return this.a.getValues(tArr);
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        return NotificationLite.isComplete(this.a.get());
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        return this.b.get().length != 0;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        return NotificationLite.isError(this.a.get());
    }

    public boolean hasValue() {
        return this.a.size() != 0;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.c) {
            return;
        }
        this.c = true;
        Object complete = NotificationLite.complete();
        ReplayBuffer<T> replayBuffer = this.a;
        replayBuffer.addFinal(complete);
        for (ReplayDisposable<T> replayDisposable : a(complete)) {
            replayBuffer.replay(replayDisposable);
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.c) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.c = true;
        Object error = NotificationLite.error(th);
        ReplayBuffer<T> replayBuffer = this.a;
        replayBuffer.addFinal(error);
        for (ReplayDisposable<T> replayDisposable : a(error)) {
            replayBuffer.replay(replayDisposable);
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.c) {
            return;
        }
        ReplayBuffer<T> replayBuffer = this.a;
        replayBuffer.add(t);
        for (ReplayDisposable<T> replayDisposable : this.b.get()) {
            replayBuffer.replay(replayDisposable);
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.c) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        ReplayDisposable<T> replayDisposable = new ReplayDisposable<>(observer, this);
        observer.onSubscribe(replayDisposable);
        if (replayDisposable.d) {
            return;
        }
        if (a((ReplayDisposable) replayDisposable) && replayDisposable.d) {
            b(replayDisposable);
        } else {
            this.a.replay(replayDisposable);
        }
    }
}
