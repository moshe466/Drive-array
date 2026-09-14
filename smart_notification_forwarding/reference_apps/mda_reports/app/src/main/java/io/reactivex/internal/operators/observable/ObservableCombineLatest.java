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
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableCombineLatest<T, R> extends Observable<R> {
    final ObservableSource<? extends T>[] a;
    final Iterable<? extends ObservableSource<? extends T>> b;
    final Function<? super Object[], ? extends R> c;
    final int d;
    final boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class CombinerObserver<T, R> extends AtomicReference<Disposable> implements Observer<T> {
        private static final long serialVersionUID = -4823716997131257941L;
        final LatestCoordinator<T, R> a;
        final int b;

        CombinerObserver(LatestCoordinator<T, R> latestCoordinator, int i) {
            this.a = latestCoordinator;
            this.b = i;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.a.a(this.b);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.a.a(this.b, th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.a.a(this.b, (int) t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    /* loaded from: classes3.dex */
    static final class LatestCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 8567835998786448817L;
        final Observer<? super R> a;
        final Function<? super Object[], ? extends R> b;
        final CombinerObserver<T, R>[] c;
        Object[] d;
        final SpscLinkedArrayQueue<Object[]> e;
        final boolean f;
        volatile boolean g;
        volatile boolean h;
        final AtomicThrowable i = new AtomicThrowable();
        int j;
        int k;

        LatestCoordinator(Observer<? super R> observer, Function<? super Object[], ? extends R> function, int i, int i2, boolean z) {
            this.a = observer;
            this.b = function;
            this.f = z;
            this.d = new Object[i];
            CombinerObserver<T, R>[] combinerObserverArr = new CombinerObserver[i];
            for (int i3 = 0; i3 < i; i3++) {
                combinerObserverArr[i3] = new CombinerObserver<>(this, i3);
            }
            this.c = combinerObserverArr;
            this.e = new SpscLinkedArrayQueue<>(i2);
        }

        void a() {
            for (CombinerObserver<T, R> combinerObserver : this.c) {
                combinerObserver.dispose();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0017, code lost:
        
            if (r2 == r0.length) goto L14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void a(int r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.Object[] r0 = r3.d     // Catch: java.lang.Throwable -> L25
                if (r0 != 0) goto L7
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                return
            L7:
                r4 = r0[r4]     // Catch: java.lang.Throwable -> L25
                r1 = 1
                if (r4 != 0) goto Le
                r4 = 1
                goto Lf
            Le:
                r4 = 0
            Lf:
                if (r4 != 0) goto L19
                int r2 = r3.k     // Catch: java.lang.Throwable -> L25
                int r2 = r2 + r1
                r3.k = r2     // Catch: java.lang.Throwable -> L25
                int r0 = r0.length     // Catch: java.lang.Throwable -> L25
                if (r2 != r0) goto L1b
            L19:
                r3.h = r1     // Catch: java.lang.Throwable -> L25
            L1b:
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                if (r4 == 0) goto L21
                r3.a()
            L21:
                r3.b()
                return
            L25:
                r4 = move-exception
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.a(int):void");
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a(int i, T t) {
            boolean z;
            synchronized (this) {
                Object[] objArr = this.d;
                if (objArr == null) {
                    return;
                }
                Object obj = objArr[i];
                int i2 = this.j;
                if (obj == null) {
                    i2++;
                    this.j = i2;
                }
                objArr[i] = t;
                if (i2 == objArr.length) {
                    this.e.offer(objArr.clone());
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    b();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0023, code lost:
        
            if (r1 == r4.length) goto L18;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void a(int r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                io.reactivex.internal.util.AtomicThrowable r0 = r2.i
                boolean r0 = r0.addThrowable(r4)
                if (r0 == 0) goto L36
                boolean r4 = r2.f
                r0 = 1
                if (r4 == 0) goto L2c
                monitor-enter(r2)
                java.lang.Object[] r4 = r2.d     // Catch: java.lang.Throwable -> L29
                if (r4 != 0) goto L14
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L29
                return
            L14:
                r3 = r4[r3]     // Catch: java.lang.Throwable -> L29
                if (r3 != 0) goto L1a
                r3 = 1
                goto L1b
            L1a:
                r3 = 0
            L1b:
                if (r3 != 0) goto L25
                int r1 = r2.k     // Catch: java.lang.Throwable -> L29
                int r1 = r1 + r0
                r2.k = r1     // Catch: java.lang.Throwable -> L29
                int r4 = r4.length     // Catch: java.lang.Throwable -> L29
                if (r1 != r4) goto L27
            L25:
                r2.h = r0     // Catch: java.lang.Throwable -> L29
            L27:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L29
                goto L2d
            L29:
                r3 = move-exception
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L29
                throw r3
            L2c:
                r3 = 1
            L2d:
                if (r3 == 0) goto L32
                r2.a()
            L32:
                r2.b()
                goto L39
            L36:
                io.reactivex.plugins.RxJavaPlugins.onError(r4)
            L39:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.a(int, java.lang.Throwable):void");
        }

        void a(SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            synchronized (this) {
                this.d = null;
            }
            spscLinkedArrayQueue.clear();
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue<Object[]> spscLinkedArrayQueue = this.e;
            Observer<? super R> observer = this.a;
            boolean z = this.f;
            int i = 1;
            while (!this.g) {
                if (z || this.i.get() == null) {
                    boolean z2 = this.h;
                    Object[] poll = spscLinkedArrayQueue.poll();
                    boolean z3 = poll == null;
                    if (z2 && z3) {
                        a((SpscLinkedArrayQueue<?>) spscLinkedArrayQueue);
                        Throwable terminate = this.i.terminate();
                        if (terminate == null) {
                            observer.onComplete();
                            return;
                        } else {
                            observer.onError(terminate);
                            return;
                        }
                    }
                    if (z3) {
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        try {
                            observer.onNext((Object) ObjectHelper.requireNonNull(this.b.apply(poll), "The combiner returned a null value"));
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.i.addThrowable(th);
                        }
                    }
                }
                a();
                a((SpscLinkedArrayQueue<?>) spscLinkedArrayQueue);
                observer.onError(this.i.terminate());
                return;
            }
            a((SpscLinkedArrayQueue<?>) spscLinkedArrayQueue);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.g) {
                return;
            }
            this.g = true;
            a();
            if (getAndIncrement() == 0) {
                a((SpscLinkedArrayQueue<?>) this.e);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.g;
        }

        public void subscribe(ObservableSource<? extends T>[] observableSourceArr) {
            CombinerObserver<T, R>[] combinerObserverArr = this.c;
            int length = combinerObserverArr.length;
            this.a.onSubscribe(this);
            for (int i = 0; i < length && !this.h && !this.g; i++) {
                observableSourceArr[i].subscribe(combinerObserverArr[i]);
            }
        }
    }

    public ObservableCombineLatest(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i, boolean z) {
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
        int i = length;
        if (i == 0) {
            EmptyDisposable.complete(observer);
        } else {
            new LatestCoordinator(observer, this.c, i, this.d, this.e).subscribe(observableSourceArr);
        }
    }
}
