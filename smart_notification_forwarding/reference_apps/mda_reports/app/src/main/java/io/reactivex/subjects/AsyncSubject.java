package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class AsyncSubject<T> extends Subject<T> {
    static final AsyncDisposable[] d = new AsyncDisposable[0];
    static final AsyncDisposable[] e = new AsyncDisposable[0];
    final AtomicReference<AsyncDisposable<T>[]> a = new AtomicReference<>(d);
    Throwable b;
    T c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class AsyncDisposable<T> extends DeferredScalarDisposable<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final AsyncSubject<T> c;

        AsyncDisposable(Observer<? super T> observer, AsyncSubject<T> asyncSubject) {
            super(observer);
            this.c = asyncSubject;
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
        public void dispose() {
            if (super.tryDispose()) {
                this.c.b(this);
            }
        }

        void onComplete() {
            if (isDisposed()) {
                return;
            }
            this.a.onComplete();
        }

        void onError(Throwable th) {
            if (isDisposed()) {
                RxJavaPlugins.onError(th);
            } else {
                this.a.onError(th);
            }
        }
    }

    AsyncSubject() {
    }

    @CheckReturnValue
    @NonNull
    public static <T> AsyncSubject<T> create() {
        return new AsyncSubject<>();
    }

    boolean a(AsyncDisposable<T> asyncDisposable) {
        AsyncDisposable<T>[] asyncDisposableArr;
        AsyncDisposable<T>[] asyncDisposableArr2;
        do {
            asyncDisposableArr = this.a.get();
            if (asyncDisposableArr == e) {
                return false;
            }
            int length = asyncDisposableArr.length;
            asyncDisposableArr2 = new AsyncDisposable[length + 1];
            System.arraycopy(asyncDisposableArr, 0, asyncDisposableArr2, 0, length);
            asyncDisposableArr2[length] = asyncDisposable;
        } while (!this.a.compareAndSet(asyncDisposableArr, asyncDisposableArr2));
        return true;
    }

    void b(AsyncDisposable<T> asyncDisposable) {
        AsyncDisposable<T>[] asyncDisposableArr;
        AsyncDisposable<T>[] asyncDisposableArr2;
        do {
            asyncDisposableArr = this.a.get();
            int length = asyncDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (asyncDisposableArr[i2] == asyncDisposable) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                asyncDisposableArr2 = d;
            } else {
                AsyncDisposable<T>[] asyncDisposableArr3 = new AsyncDisposable[length - 1];
                System.arraycopy(asyncDisposableArr, 0, asyncDisposableArr3, 0, i);
                System.arraycopy(asyncDisposableArr, i + 1, asyncDisposableArr3, i, (length - i) - 1);
                asyncDisposableArr2 = asyncDisposableArr3;
            }
        } while (!this.a.compareAndSet(asyncDisposableArr, asyncDisposableArr2));
    }

    @Override // io.reactivex.subjects.Subject
    public Throwable getThrowable() {
        if (this.a.get() == e) {
            return this.b;
        }
        return null;
    }

    @Nullable
    public T getValue() {
        if (this.a.get() == e) {
            return this.c;
        }
        return null;
    }

    @Deprecated
    public Object[] getValues() {
        T value = getValue();
        return value != null ? new Object[]{value} : new Object[0];
    }

    @Deprecated
    public T[] getValues(T[] tArr) {
        T value = getValue();
        if (value == null) {
            if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        if (tArr.length == 0) {
            tArr = (T[]) Arrays.copyOf(tArr, 1);
        }
        tArr[0] = value;
        if (tArr.length != 1) {
            tArr[1] = null;
        }
        return tArr;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        return this.a.get() == e && this.b == null;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        return this.a.get().length != 0;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        return this.a.get() == e && this.b != null;
    }

    public boolean hasValue() {
        return this.a.get() == e && this.c != null;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        AsyncDisposable<T>[] asyncDisposableArr = this.a.get();
        AsyncDisposable<T>[] asyncDisposableArr2 = e;
        if (asyncDisposableArr == asyncDisposableArr2) {
            return;
        }
        T t = this.c;
        AsyncDisposable<T>[] andSet = this.a.getAndSet(asyncDisposableArr2);
        int i = 0;
        if (t == null) {
            int length = andSet.length;
            while (i < length) {
                andSet[i].onComplete();
                i++;
            }
            return;
        }
        int length2 = andSet.length;
        while (i < length2) {
            andSet[i].complete(t);
            i++;
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        AsyncDisposable<T>[] asyncDisposableArr = this.a.get();
        AsyncDisposable<T>[] asyncDisposableArr2 = e;
        if (asyncDisposableArr == asyncDisposableArr2) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.c = null;
        this.b = th;
        for (AsyncDisposable<T> asyncDisposable : this.a.getAndSet(asyncDisposableArr2)) {
            asyncDisposable.onError(th);
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.a.get() == e) {
            return;
        }
        this.c = t;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.a.get() == e) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        AsyncDisposable<T> asyncDisposable = new AsyncDisposable<>(observer, this);
        observer.onSubscribe(asyncDisposable);
        if (a(asyncDisposable)) {
            if (asyncDisposable.isDisposed()) {
                b(asyncDisposable);
                return;
            }
            return;
        }
        Throwable th = this.b;
        if (th != null) {
            observer.onError(th);
            return;
        }
        T t = this.c;
        if (t != null) {
            asyncDisposable.complete(t);
        } else {
            asyncDisposable.onComplete();
        }
    }
}
