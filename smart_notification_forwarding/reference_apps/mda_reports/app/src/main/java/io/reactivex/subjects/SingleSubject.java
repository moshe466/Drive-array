package io.reactivex.subjects;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class SingleSubject<T> extends Single<T> implements SingleObserver<T> {
    static final SingleDisposable[] e = new SingleDisposable[0];
    static final SingleDisposable[] f = new SingleDisposable[0];
    T c;
    Throwable d;
    final AtomicBoolean b = new AtomicBoolean();
    final AtomicReference<SingleDisposable<T>[]> a = new AtomicReference<>(e);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class SingleDisposable<T> extends AtomicReference<SingleSubject<T>> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        final SingleObserver<? super T> a;

        SingleDisposable(SingleObserver<? super T> singleObserver, SingleSubject<T> singleSubject) {
            this.a = singleObserver;
            lazySet(singleSubject);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SingleSubject<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.b(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == null;
        }
    }

    SingleSubject() {
    }

    @CheckReturnValue
    @NonNull
    public static <T> SingleSubject<T> create() {
        return new SingleSubject<>();
    }

    boolean a(@NonNull SingleDisposable<T> singleDisposable) {
        SingleDisposable<T>[] singleDisposableArr;
        SingleDisposable<T>[] singleDisposableArr2;
        do {
            singleDisposableArr = this.a.get();
            if (singleDisposableArr == f) {
                return false;
            }
            int length = singleDisposableArr.length;
            singleDisposableArr2 = new SingleDisposable[length + 1];
            System.arraycopy(singleDisposableArr, 0, singleDisposableArr2, 0, length);
            singleDisposableArr2[length] = singleDisposable;
        } while (!this.a.compareAndSet(singleDisposableArr, singleDisposableArr2));
        return true;
    }

    void b(@NonNull SingleDisposable<T> singleDisposable) {
        SingleDisposable<T>[] singleDisposableArr;
        SingleDisposable<T>[] singleDisposableArr2;
        do {
            singleDisposableArr = this.a.get();
            int length = singleDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (singleDisposableArr[i2] == singleDisposable) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                singleDisposableArr2 = e;
            } else {
                SingleDisposable<T>[] singleDisposableArr3 = new SingleDisposable[length - 1];
                System.arraycopy(singleDisposableArr, 0, singleDisposableArr3, 0, i);
                System.arraycopy(singleDisposableArr, i + 1, singleDisposableArr3, i, (length - i) - 1);
                singleDisposableArr2 = singleDisposableArr3;
            }
        } while (!this.a.compareAndSet(singleDisposableArr, singleDisposableArr2));
    }

    @Nullable
    public Throwable getThrowable() {
        if (this.a.get() == f) {
            return this.d;
        }
        return null;
    }

    @Nullable
    public T getValue() {
        if (this.a.get() == f) {
            return this.c;
        }
        return null;
    }

    public boolean hasObservers() {
        return this.a.get().length != 0;
    }

    public boolean hasThrowable() {
        return this.a.get() == f && this.d != null;
    }

    public boolean hasValue() {
        return this.a.get() == f && this.c != null;
    }

    @Override // io.reactivex.SingleObserver
    public void onError(@NonNull Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.b.compareAndSet(false, true)) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.d = th;
        for (SingleDisposable<T> singleDisposable : this.a.getAndSet(f)) {
            singleDisposable.a.onError(th);
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(@NonNull Disposable disposable) {
        if (this.a.get() == f) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(@NonNull T t) {
        ObjectHelper.requireNonNull(t, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.b.compareAndSet(false, true)) {
            this.c = t;
            for (SingleDisposable<T> singleDisposable : this.a.getAndSet(f)) {
                singleDisposable.a.onSuccess(t);
            }
        }
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(@NonNull SingleObserver<? super T> singleObserver) {
        SingleDisposable<T> singleDisposable = new SingleDisposable<>(singleObserver, this);
        singleObserver.onSubscribe(singleDisposable);
        if (a(singleDisposable)) {
            if (singleDisposable.isDisposed()) {
                b(singleDisposable);
            }
        } else {
            Throwable th = this.d;
            if (th != null) {
                singleObserver.onError(th);
            } else {
                singleObserver.onSuccess(this.c);
            }
        }
    }
}
