package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableZip<T, R> extends Observable<R> {
    final ObservableSource<? extends T>[] a;
    final Iterable<? extends ObservableSource<? extends T>> b;
    final Function<? super Object[], ? extends R> c;
    final int d;
    final boolean e;

    /* loaded from: classes3.dex */
    static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 2983708048395377667L;
        final Observer<? super R> a;
        final Function<? super Object[], ? extends R> b;
        final ZipObserver<T, R>[] c;
        final T[] d;
        final boolean e;
        volatile boolean f;

        ZipCoordinator(Observer<? super R> observer, Function<? super Object[], ? extends R> function, int i, boolean z) {
            this.a = observer;
            this.b = function;
            this.c = new ZipObserver[i];
            this.d = (T[]) new Object[i];
            this.e = z;
        }

        void a() {
            c();
            b();
        }

        boolean a(boolean z, boolean z2, Observer<? super R> observer, boolean z3, ZipObserver<?, ?> zipObserver) {
            if (this.f) {
                a();
                return true;
            }
            if (!z) {
                return false;
            }
            if (z3) {
                if (!z2) {
                    return false;
                }
                Throwable th = zipObserver.d;
                a();
                if (th != null) {
                    observer.onError(th);
                } else {
                    observer.onComplete();
                }
                return true;
            }
            Throwable th2 = zipObserver.d;
            if (th2 != null) {
                a();
                observer.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            a();
            observer.onComplete();
            return true;
        }

        void b() {
            for (ZipObserver<T, R> zipObserver : this.c) {
                zipObserver.dispose();
            }
        }

        void c() {
            for (ZipObserver<T, R> zipObserver : this.c) {
                zipObserver.b.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f) {
                return;
            }
            this.f = true;
            b();
            if (getAndIncrement() == 0) {
                c();
            }
        }

        public void drain() {
            Throwable th;
            if (getAndIncrement() != 0) {
                return;
            }
            ZipObserver<T, R>[] zipObserverArr = this.c;
            Observer<? super R> observer = this.a;
            T[] tArr = this.d;
            boolean z = this.e;
            int i = 1;
            while (true) {
                int i2 = 0;
                int i3 = 0;
                for (ZipObserver<T, R> zipObserver : zipObserverArr) {
                    if (tArr[i3] == null) {
                        boolean z2 = zipObserver.c;
                        T poll = zipObserver.b.poll();
                        boolean z3 = poll == null;
                        if (a(z2, z3, observer, z, zipObserver)) {
                            return;
                        }
                        if (z3) {
                            i2++;
                        } else {
                            tArr[i3] = poll;
                        }
                    } else if (zipObserver.c && !z && (th = zipObserver.d) != null) {
                        a();
                        observer.onError(th);
                        return;
                    }
                    i3++;
                }
                if (i2 != 0) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    try {
                        observer.onNext((Object) ObjectHelper.requireNonNull(this.b.apply(tArr.clone()), "The zipper returned a null value"));
                        Arrays.fill(tArr, (Object) null);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        a();
                        observer.onError(th2);
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f;
        }

        public void subscribe(ObservableSource<? extends T>[] observableSourceArr, int i) {
            ZipObserver<T, R>[] zipObserverArr = this.c;
            int length = zipObserverArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                zipObserverArr[i2] = new ZipObserver<>(this, i);
            }
            lazySet(0);
            this.a.onSubscribe(this);
            for (int i3 = 0; i3 < length && !this.f; i3++) {
                observableSourceArr[i3].subscribe(zipObserverArr[i3]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ZipObserver<T, R> implements Observer<T> {
        final ZipCoordinator<T, R> a;
        final SpscLinkedArrayQueue<T> b;
        volatile boolean c;
        Throwable d;
        final AtomicReference<Disposable> e = new AtomicReference<>();

        ZipObserver(ZipCoordinator<T, R> zipCoordinator, int i) {
            this.a = zipCoordinator;
            this.b = new SpscLinkedArrayQueue<>(i);
        }

        public void dispose() {
            DisposableHelper.dispose(this.e);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.c = true;
            this.a.drain();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.d = th;
            this.c = true;
            this.a.drain();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.b.offer(t);
            this.a.drain();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.e, disposable);
        }
    }

    public ObservableZip(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.a = observableSourceArr;
        this.b = iterable;
        this.c = function;
        this.d = i;
        this.e = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super R> observer) {
        int length;
        ObservableSource<? extends T>[] observableSourceArr = this.a;
        if (observableSourceArr == null) {
            observableSourceArr = new Observable[8];
            length = 0;
            for (ObservableSource<? extends T> observableSource : this.b) {
                if (length == observableSourceArr.length) {
                    ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[(length >> 2) + length];
                    System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, length);
                    observableSourceArr = observableSourceArr2;
                }
                observableSourceArr[length] = observableSource;
                length++;
            }
        } else {
            length = observableSourceArr.length;
        }
        if (length == 0) {
            EmptyDisposable.complete(observer);
        } else {
            new ZipCoordinator(observer, this.c, length, this.e).subscribe(observableSourceArr, this.d);
        }
    }
}
