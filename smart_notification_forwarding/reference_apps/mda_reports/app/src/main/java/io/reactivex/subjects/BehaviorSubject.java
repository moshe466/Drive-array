package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes3.dex */
public final class BehaviorSubject<T> extends Subject<T> {
    private static final Object[] EMPTY_ARRAY = new Object[0];
    static final BehaviorDisposable[] h = new BehaviorDisposable[0];
    static final BehaviorDisposable[] i = new BehaviorDisposable[0];
    final AtomicReference<Object> a;
    final AtomicReference<BehaviorDisposable<T>[]> b;
    final ReadWriteLock c;
    final Lock d;
    final Lock e;
    final AtomicReference<Throwable> f;
    long g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class BehaviorDisposable<T> implements Disposable, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
        final Observer<? super T> a;
        final BehaviorSubject<T> b;
        boolean c;
        boolean d;
        AppendOnlyLinkedArrayList<Object> e;
        boolean f;
        volatile boolean g;
        long h;

        BehaviorDisposable(Observer<? super T> observer, BehaviorSubject<T> behaviorSubject) {
            this.a = observer;
            this.b = behaviorSubject;
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
                BehaviorSubject<T> behaviorSubject = this.b;
                Lock lock = behaviorSubject.d;
                lock.lock();
                this.h = behaviorSubject.g;
                Object obj = behaviorSubject.a.get();
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

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.g) {
                return;
            }
            this.g = true;
            this.b.b((BehaviorDisposable) this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.g;
        }

        @Override // io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return this.g || NotificationLite.accept(obj, this.a);
        }
    }

    BehaviorSubject() {
        this.c = new ReentrantReadWriteLock();
        this.d = this.c.readLock();
        this.e = this.c.writeLock();
        this.b = new AtomicReference<>(h);
        this.a = new AtomicReference<>();
        this.f = new AtomicReference<>();
    }

    BehaviorSubject(T t) {
        this();
        this.a.lazySet(ObjectHelper.requireNonNull(t, "defaultValue is null"));
    }

    @CheckReturnValue
    @NonNull
    public static <T> BehaviorSubject<T> create() {
        return new BehaviorSubject<>();
    }

    @CheckReturnValue
    @NonNull
    public static <T> BehaviorSubject<T> createDefault(T t) {
        return new BehaviorSubject<>(t);
    }

    void a(Object obj) {
        this.e.lock();
        this.g++;
        this.a.lazySet(obj);
        this.e.unlock();
    }

    boolean a(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable<T>[] behaviorDisposableArr;
        BehaviorDisposable<T>[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = this.b.get();
            if (behaviorDisposableArr == i) {
                return false;
            }
            int length = behaviorDisposableArr.length;
            behaviorDisposableArr2 = new BehaviorDisposable[length + 1];
            System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr2, 0, length);
            behaviorDisposableArr2[length] = behaviorDisposable;
        } while (!this.b.compareAndSet(behaviorDisposableArr, behaviorDisposableArr2));
        return true;
    }

    void b(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable<T>[] behaviorDisposableArr;
        BehaviorDisposable<T>[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = this.b.get();
            int length = behaviorDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (behaviorDisposableArr[i3] == behaviorDisposable) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            if (i2 < 0) {
                return;
            }
            if (length == 1) {
                behaviorDisposableArr2 = h;
            } else {
                BehaviorDisposable<T>[] behaviorDisposableArr3 = new BehaviorDisposable[length - 1];
                System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr3, 0, i2);
                System.arraycopy(behaviorDisposableArr, i2 + 1, behaviorDisposableArr3, i2, (length - i2) - 1);
                behaviorDisposableArr2 = behaviorDisposableArr3;
            }
        } while (!this.b.compareAndSet(behaviorDisposableArr, behaviorDisposableArr2));
    }

    BehaviorDisposable<T>[] b(Object obj) {
        BehaviorDisposable<T>[] andSet = this.b.getAndSet(i);
        if (andSet != i) {
            a(obj);
        }
        return andSet;
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
        Object obj = this.a.get();
        if (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) {
            return null;
        }
        return (T) NotificationLite.getValue(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public Object[] getValues() {
        Object[] values = getValues(EMPTY_ARRAY);
        return values == EMPTY_ARRAY ? new Object[0] : values;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public T[] getValues(T[] tArr) {
        Object obj = this.a.get();
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
        Object obj = this.a.get();
        return (obj == null || NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? false : true;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.f.compareAndSet(null, ExceptionHelper.TERMINATED)) {
            Object complete = NotificationLite.complete();
            for (BehaviorDisposable<T> behaviorDisposable : b(complete)) {
                behaviorDisposable.a(complete, this.g);
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f.compareAndSet(null, th)) {
            RxJavaPlugins.onError(th);
            return;
        }
        Object error = NotificationLite.error(th);
        for (BehaviorDisposable<T> behaviorDisposable : b(error)) {
            behaviorDisposable.a(error, this.g);
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f.get() != null) {
            return;
        }
        Object next = NotificationLite.next(t);
        a(next);
        for (BehaviorDisposable<T> behaviorDisposable : this.b.get()) {
            behaviorDisposable.a(next, this.g);
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.f.get() != null) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        BehaviorDisposable<T> behaviorDisposable = new BehaviorDisposable<>(observer, this);
        observer.onSubscribe(behaviorDisposable);
        if (a((BehaviorDisposable) behaviorDisposable)) {
            if (behaviorDisposable.g) {
                b((BehaviorDisposable) behaviorDisposable);
                return;
            } else {
                behaviorDisposable.a();
                return;
            }
        }
        Throwable th = this.f.get();
        if (th == ExceptionHelper.TERMINATED) {
            observer.onComplete();
        } else {
            observer.onError(th);
        }
    }
}
