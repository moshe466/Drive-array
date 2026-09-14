package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.LinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableCache<T> extends AbstractObservableWithUpstream<T, T> {
    final CacheState<T> b;
    final AtomicBoolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class CacheState<T> extends LinkedArrayList implements Observer<T> {
        static final ReplayDisposable[] j = new ReplayDisposable[0];
        static final ReplayDisposable[] k = new ReplayDisposable[0];
        final Observable<? extends T> f;
        final SequentialDisposable g;
        final AtomicReference<ReplayDisposable<T>[]> h;
        boolean i;

        CacheState(Observable<? extends T> observable, int i) {
            super(i);
            this.f = observable;
            this.h = new AtomicReference<>(j);
            this.g = new SequentialDisposable();
        }

        public boolean addChild(ReplayDisposable<T> replayDisposable) {
            ReplayDisposable<T>[] replayDisposableArr;
            ReplayDisposable<T>[] replayDisposableArr2;
            do {
                replayDisposableArr = this.h.get();
                if (replayDisposableArr == k) {
                    return false;
                }
                int length = replayDisposableArr.length;
                replayDisposableArr2 = new ReplayDisposable[length + 1];
                System.arraycopy(replayDisposableArr, 0, replayDisposableArr2, 0, length);
                replayDisposableArr2[length] = replayDisposable;
            } while (!this.h.compareAndSet(replayDisposableArr, replayDisposableArr2));
            return true;
        }

        public void connect() {
            this.f.subscribe(this);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.i) {
                return;
            }
            this.i = true;
            add(NotificationLite.complete());
            this.g.dispose();
            for (ReplayDisposable<T> replayDisposable : this.h.getAndSet(k)) {
                replayDisposable.replay();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.i) {
                return;
            }
            this.i = true;
            add(NotificationLite.error(th));
            this.g.dispose();
            for (ReplayDisposable<T> replayDisposable : this.h.getAndSet(k)) {
                replayDisposable.replay();
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.i) {
                return;
            }
            add(NotificationLite.next(t));
            for (ReplayDisposable<T> replayDisposable : this.h.get()) {
                replayDisposable.replay();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.g.update(disposable);
        }

        public void removeChild(ReplayDisposable<T> replayDisposable) {
            ReplayDisposable<T>[] replayDisposableArr;
            ReplayDisposable<T>[] replayDisposableArr2;
            do {
                replayDisposableArr = this.h.get();
                int length = replayDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (replayDisposableArr[i2].equals(replayDisposable)) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    replayDisposableArr2 = j;
                } else {
                    ReplayDisposable<T>[] replayDisposableArr3 = new ReplayDisposable[length - 1];
                    System.arraycopy(replayDisposableArr, 0, replayDisposableArr3, 0, i);
                    System.arraycopy(replayDisposableArr, i + 1, replayDisposableArr3, i, (length - i) - 1);
                    replayDisposableArr2 = replayDisposableArr3;
                }
            } while (!this.h.compareAndSet(replayDisposableArr, replayDisposableArr2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ReplayDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 7058506693698832024L;
        final Observer<? super T> a;
        final CacheState<T> b;
        Object[] c;
        int d;
        int e;
        volatile boolean f;

        ReplayDisposable(Observer<? super T> observer, CacheState<T> cacheState) {
            this.a = observer;
            this.b = cacheState;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f) {
                return;
            }
            this.f = true;
            this.b.removeChild(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f;
        }

        public void replay() {
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super T> observer = this.a;
            int i = 1;
            while (!this.f) {
                int size = this.b.size();
                if (size != 0) {
                    Object[] objArr = this.c;
                    if (objArr == null) {
                        objArr = this.b.head();
                        this.c = objArr;
                    }
                    int length = objArr.length - 1;
                    int i2 = this.e;
                    int i3 = this.d;
                    while (i2 < size) {
                        if (this.f) {
                            return;
                        }
                        if (i3 == length) {
                            objArr = (Object[]) objArr[length];
                            i3 = 0;
                        }
                        if (NotificationLite.accept(objArr[i3], observer)) {
                            return;
                        }
                        i3++;
                        i2++;
                    }
                    if (this.f) {
                        return;
                    }
                    this.e = i2;
                    this.d = i3;
                    this.c = objArr;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }

    private ObservableCache(Observable<T> observable, CacheState<T> cacheState) {
        super(observable);
        this.b = cacheState;
        this.c = new AtomicBoolean();
    }

    public static <T> Observable<T> from(Observable<T> observable) {
        return from(observable, 16);
    }

    public static <T> Observable<T> from(Observable<T> observable, int i) {
        ObjectHelper.verifyPositive(i, "capacityHint");
        return RxJavaPlugins.onAssembly(new ObservableCache(observable, new CacheState(observable, i)));
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        ReplayDisposable<T> replayDisposable = new ReplayDisposable<>(observer, this.b);
        observer.onSubscribe(replayDisposable);
        this.b.addChild(replayDisposable);
        if (!this.c.get() && this.c.compareAndSet(false, true)) {
            this.b.connect();
        }
        replayDisposable.replay();
    }
}
