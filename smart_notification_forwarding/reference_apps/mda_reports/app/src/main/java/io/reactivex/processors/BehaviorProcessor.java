package io.reactivex.processors;

import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes3.dex */
public final class BehaviorProcessor<T> extends FlowableProcessor<T> {
    static final Object[] i = new Object[0];
    static final BehaviorSubscription[] j = new BehaviorSubscription[0];
    static final BehaviorSubscription[] k = new BehaviorSubscription[0];
    final AtomicReference<BehaviorSubscription<T>[]> b;
    final ReadWriteLock c;
    final Lock d;
    final Lock e;
    final AtomicReference<Object> f;
    final AtomicReference<Throwable> g;
    long h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class BehaviorSubscription<T> extends AtomicLong implements Subscription, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
        private static final long serialVersionUID = 3293175281126227086L;
        final Subscriber<? super T> a;
        final BehaviorProcessor<T> b;
        boolean c;
        boolean d;
        AppendOnlyLinkedArrayList<Object> e;
        boolean f;
        volatile boolean g;
        long h;

        BehaviorSubscription(Subscriber<? super T> subscriber, BehaviorProcessor<T> behaviorProcessor) {
            this.a = subscriber;
            this.b = behaviorProcessor;
        }

        void a() {
            if (this.g) {
                return;
            }
            synchronized (this) {
                if (this.g) {
                    return;
                }
                if (this.c) {
                    return;
                }
                BehaviorProcessor<T> behaviorProcessor = this.b;
                Lock lock = behaviorProcessor.d;
                lock.lock();
                this.h = behaviorProcessor.h;
                Object obj = behaviorProcessor.f.get();
                lock.unlock();
                this.d = obj != null;
                this.c = true;
                if (obj == null || test(obj)) {
                    return;
                }
                b();
            }
        }

        void a(Object obj, long j) {
            if (this.g) {
                return;
            }
            if (!this.f) {
                synchronized (this) {
                    if (this.g) {
                        return;
                    }
                    if (this.h == j) {
                        return;
                    }
                    if (this.d) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.e;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.e = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(obj);
                        return;
                    }
                    this.c = true;
                    this.f = true;
                }
            }
            test(obj);
        }

        void b() {
            AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
            while (!this.g) {
                synchronized (this) {
                    appendOnlyLinkedArrayList = this.e;
                    if (appendOnlyLinkedArrayList == null) {
                        this.d = false;
                        return;
                    }
                    this.e = null;
                }
                appendOnlyLinkedArrayList.forEachWhile(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.g) {
                return;
            }
            this.g = true;
            this.b.b((BehaviorSubscription) this);
        }

        public boolean isFull() {
            return get() == 0;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this, j);
            }
        }

        @Override // io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            if (this.g) {
                return true;
            }
            if (NotificationLite.isComplete(obj)) {
                this.a.onComplete();
                return true;
            }
            if (NotificationLite.isError(obj)) {
                this.a.onError(NotificationLite.getError(obj));
                return true;
            }
            long j = get();
            if (j == 0) {
                cancel();
                this.a.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                return true;
            }
            this.a.onNext((Object) NotificationLite.getValue(obj));
            if (j == Long.MAX_VALUE) {
                return false;
            }
            decrementAndGet();
            return false;
        }
    }

    BehaviorProcessor() {
        this.f = new AtomicReference<>();
        this.c = new ReentrantReadWriteLock();
        this.d = this.c.readLock();
        this.e = this.c.writeLock();
        this.b = new AtomicReference<>(j);
        this.g = new AtomicReference<>();
    }

    BehaviorProcessor(T t) {
        this();
        this.f.lazySet(ObjectHelper.requireNonNull(t, "defaultValue is null"));
    }

    @CheckReturnValue
    @NonNull
    public static <T> BehaviorProcessor<T> create() {
        return new BehaviorProcessor<>();
    }

    @CheckReturnValue
    @NonNull
    public static <T> BehaviorProcessor<T> createDefault(T t) {
        ObjectHelper.requireNonNull(t, "defaultValue is null");
        return new BehaviorProcessor<>(t);
    }

    void a(Object obj) {
        Lock lock = this.e;
        lock.lock();
        this.h++;
        this.f.lazySet(obj);
        lock.unlock();
    }

    boolean a(BehaviorSubscription<T> behaviorSubscription) {
        BehaviorSubscription<T>[] behaviorSubscriptionArr;
        BehaviorSubscription<T>[] behaviorSubscriptionArr2;
        do {
            behaviorSubscriptionArr = this.b.get();
            if (behaviorSubscriptionArr == k) {
                return false;
            }
            int length = behaviorSubscriptionArr.length;
            behaviorSubscriptionArr2 = new BehaviorSubscription[length + 1];
            System.arraycopy(behaviorSubscriptionArr, 0, behaviorSubscriptionArr2, 0, length);
            behaviorSubscriptionArr2[length] = behaviorSubscription;
        } while (!this.b.compareAndSet(behaviorSubscriptionArr, behaviorSubscriptionArr2));
        return true;
    }

    void b(BehaviorSubscription<T> behaviorSubscription) {
        BehaviorSubscription<T>[] behaviorSubscriptionArr;
        BehaviorSubscription<T>[] behaviorSubscriptionArr2;
        do {
            behaviorSubscriptionArr = this.b.get();
            int length = behaviorSubscriptionArr.length;
            if (length == 0) {
                return;
            }
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (behaviorSubscriptionArr[i3] == behaviorSubscription) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            if (i2 < 0) {
                return;
            }
            if (length == 1) {
                behaviorSubscriptionArr2 = j;
            } else {
                BehaviorSubscription<T>[] behaviorSubscriptionArr3 = new BehaviorSubscription[length - 1];
                System.arraycopy(behaviorSubscriptionArr, 0, behaviorSubscriptionArr3, 0, i2);
                System.arraycopy(behaviorSubscriptionArr, i2 + 1, behaviorSubscriptionArr3, i2, (length - i2) - 1);
                behaviorSubscriptionArr2 = behaviorSubscriptionArr3;
            }
        } while (!this.b.compareAndSet(behaviorSubscriptionArr, behaviorSubscriptionArr2));
    }

    BehaviorSubscription<T>[] b(Object obj) {
        BehaviorSubscription<T>[] behaviorSubscriptionArr = this.b.get();
        BehaviorSubscription<T>[] behaviorSubscriptionArr2 = k;
        if (behaviorSubscriptionArr != behaviorSubscriptionArr2 && (behaviorSubscriptionArr = this.b.getAndSet(behaviorSubscriptionArr2)) != k) {
            a(obj);
        }
        return behaviorSubscriptionArr;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    @Nullable
    public Throwable getThrowable() {
        Object obj = this.f.get();
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    @Nullable
    public T getValue() {
        Object obj = this.f.get();
        if (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
            return null;
        }
        return (T) NotificationLite.getValue(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public Object[] getValues() {
        Object[] values = getValues(i);
        return values == i ? new Object[0] : values;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public T[] getValues(T[] tArr) {
        Object obj = this.f.get();
        if (obj == null || NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
            if (tArr.length != 0) {
                tArr[0] = 0;
            }
            return tArr;
        }
        Object value = NotificationLite.getValue(obj);
        if (tArr.length == 0) {
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
            tArr2[0] = value;
            return tArr2;
        }
        tArr[0] = value;
        if (tArr.length == 1) {
            return tArr;
        }
        tArr[1] = 0;
        return tArr;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        return NotificationLite.isComplete(this.f.get());
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        return this.b.get().length != 0;
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        return NotificationLite.isError(this.f.get());
    }

    public boolean hasValue() {
        Object obj = this.f.get();
        return (obj == null || NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? false : true;
    }

    @Experimental
    public boolean offer(T t) {
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return true;
        }
        BehaviorSubscription<T>[] behaviorSubscriptionArr = this.b.get();
        for (BehaviorSubscription<T> behaviorSubscription : behaviorSubscriptionArr) {
            if (behaviorSubscription.isFull()) {
                return false;
            }
        }
        Object next = NotificationLite.next(t);
        a(next);
        for (BehaviorSubscription<T> behaviorSubscription2 : behaviorSubscriptionArr) {
            behaviorSubscription2.a(next, this.h);
        }
        return true;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.g.compareAndSet(null, ExceptionHelper.TERMINATED)) {
            Object complete = NotificationLite.complete();
            for (BehaviorSubscription<T> behaviorSubscription : b(complete)) {
                behaviorSubscription.a(complete, this.h);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.g.compareAndSet(null, th)) {
            RxJavaPlugins.onError(th);
            return;
        }
        Object error = NotificationLite.error(th);
        for (BehaviorSubscription<T> behaviorSubscription : b(error)) {
            behaviorSubscription.a(error, this.h);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.g.get() != null) {
            return;
        }
        Object next = NotificationLite.next(t);
        a(next);
        for (BehaviorSubscription<T> behaviorSubscription : this.b.get()) {
            behaviorSubscription.a(next, this.h);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(Subscription subscription) {
        if (this.g.get() != null) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        BehaviorSubscription<T> behaviorSubscription = new BehaviorSubscription<>(subscriber, this);
        subscriber.onSubscribe(behaviorSubscription);
        if (a((BehaviorSubscription) behaviorSubscription)) {
            if (behaviorSubscription.g) {
                b((BehaviorSubscription) behaviorSubscription);
                return;
            } else {
                behaviorSubscription.a();
                return;
            }
        }
        Throwable th = this.g.get();
        if (th == ExceptionHelper.TERMINATED) {
            subscriber.onComplete();
        } else {
            subscriber.onError(th);
        }
    }
}
