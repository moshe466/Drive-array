package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class MaybeCache<T> extends Maybe<T> implements MaybeObserver<T> {
    static final CacheDisposable[] e = new CacheDisposable[0];
    static final CacheDisposable[] f = new CacheDisposable[0];
    final AtomicReference<MaybeSource<T>> a;
    final AtomicReference<CacheDisposable<T>[]> b = new AtomicReference<>(e);
    T c;
    Throwable d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class CacheDisposable<T> extends AtomicReference<MaybeCache<T>> implements Disposable {
        private static final long serialVersionUID = -5791853038359966195L;
        final MaybeObserver<? super T> a;

        CacheDisposable(MaybeObserver<? super T> maybeObserver, MaybeCache<T> maybeCache) {
            super(maybeCache);
            this.a = maybeObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            MaybeCache<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.b(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == null;
        }
    }

    public MaybeCache(MaybeSource<T> maybeSource) {
        this.a = new AtomicReference<>(maybeSource);
    }

    boolean a(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable<T>[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.b.get();
            if (cacheDisposableArr == f) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[length + 1];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!this.b.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    void b(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable<T>[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.b.get();
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
                cacheDisposableArr2 = e;
            } else {
                CacheDisposable<T>[] cacheDisposableArr3 = new CacheDisposable[length - 1];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i);
                System.arraycopy(cacheDisposableArr, i + 1, cacheDisposableArr3, i, (length - i) - 1);
                cacheDisposableArr2 = cacheDisposableArr3;
            }
        } while (!this.b.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        for (CacheDisposable<T> cacheDisposable : this.b.getAndSet(f)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.a.onComplete();
            }
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable th) {
        this.d = th;
        for (CacheDisposable<T> cacheDisposable : this.b.getAndSet(f)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.a.onError(th);
            }
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(Disposable disposable) {
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T t) {
        this.c = t;
        for (CacheDisposable<T> cacheDisposable : this.b.getAndSet(f)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.a.onSuccess(t);
            }
        }
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        CacheDisposable<T> cacheDisposable = new CacheDisposable<>(maybeObserver, this);
        maybeObserver.onSubscribe(cacheDisposable);
        if (a(cacheDisposable)) {
            if (cacheDisposable.isDisposed()) {
                b(cacheDisposable);
                return;
            }
            MaybeSource<T> andSet = this.a.getAndSet(null);
            if (andSet != null) {
                andSet.subscribe(this);
                return;
            }
            return;
        }
        if (cacheDisposable.isDisposed()) {
            return;
        }
        Throwable th = this.d;
        if (th != null) {
            maybeObserver.onError(th);
            return;
        }
        T t = this.c;
        if (t != null) {
            maybeObserver.onSuccess(t);
        } else {
            maybeObserver.onComplete();
        }
    }
}
