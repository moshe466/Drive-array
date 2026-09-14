package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class SingleCache<T> extends Single<T> implements SingleObserver<T> {
    static final CacheDisposable[] f = new CacheDisposable[0];
    static final CacheDisposable[] g = new CacheDisposable[0];
    final SingleSource<? extends T> a;
    final AtomicInteger b = new AtomicInteger();
    final AtomicReference<CacheDisposable<T>[]> c = new AtomicReference<>(f);
    T d;
    Throwable e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class CacheDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 7514387411091976596L;
        final SingleObserver<? super T> a;
        final SingleCache<T> b;

        CacheDisposable(SingleObserver<? super T> singleObserver, SingleCache<T> singleCache) {
            this.a = singleObserver;
            this.b = singleCache;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.b.b(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }
    }

    public SingleCache(SingleSource<? extends T> singleSource) {
        this.a = singleSource;
    }

    boolean a(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable<T>[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.c.get();
            if (cacheDisposableArr == g) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[length + 1];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!this.c.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    void b(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable<T>[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.c.get();
            int length = cacheDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (cacheDisposableArr[i2] == cacheDisposable) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                cacheDisposableArr2 = f;
            } else {
                CacheDisposable<T>[] cacheDisposableArr3 = new CacheDisposable[length - 1];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i);
                System.arraycopy(cacheDisposableArr, i + 1, cacheDisposableArr3, i, (length - i) - 1);
                cacheDisposableArr2 = cacheDisposableArr3;
            }
        } while (!this.c.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable th) {
        this.e = th;
        for (CacheDisposable<T> cacheDisposable : this.c.getAndSet(g)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.a.onError(th);
            }
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable disposable) {
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T t) {
        this.d = t;
        for (CacheDisposable<T> cacheDisposable : this.c.getAndSet(g)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.a.onSuccess(t);
            }
        }
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        CacheDisposable<T> cacheDisposable = new CacheDisposable<>(singleObserver, this);
        singleObserver.onSubscribe(cacheDisposable);
        if (a(cacheDisposable)) {
            if (cacheDisposable.isDisposed()) {
                b(cacheDisposable);
            }
            if (this.b.getAndIncrement() == 0) {
                this.a.subscribe(this);
                return;
            }
            return;
        }
        Throwable th = this.e;
        if (th != null) {
            singleObserver.onError(th);
        } else {
            singleObserver.onSuccess(this.d);
        }
    }
}
