package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableFlatMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    final Function<? super T, ? extends ObservableSource<? extends U>> b;
    final boolean c;
    final int d;
    final int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class InnerObserver<T, U> extends AtomicReference<Disposable> implements Observer<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        final long a;
        final MergeObserver<T, U> b;
        volatile boolean c;
        volatile SimpleQueue<U> d;
        int e;

        InnerObserver(MergeObserver<T, U> mergeObserver, long j) {
            this.a = j;
            this.b = mergeObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.c = true;
            this.b.c();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.b.h.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            MergeObserver<T, U> mergeObserver = this.b;
            if (!mergeObserver.c) {
                mergeObserver.b();
            }
            this.c = true;
            this.b.c();
        }

        @Override // io.reactivex.Observer
        public void onNext(U u) {
            if (this.e == 0) {
                this.b.a(u, this);
            } else {
                this.b.c();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable) && (disposable instanceof QueueDisposable)) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int requestFusion = queueDisposable.requestFusion(7);
                if (requestFusion == 1) {
                    this.e = requestFusion;
                    this.d = queueDisposable;
                    this.c = true;
                    this.b.c();
                    return;
                }
                if (requestFusion == 2) {
                    this.e = requestFusion;
                    this.d = queueDisposable;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class MergeObserver<T, U> extends AtomicInteger implements Disposable, Observer<T> {
        static final InnerObserver<?, ?>[] q = new InnerObserver[0];
        static final InnerObserver<?, ?>[] r = new InnerObserver[0];
        private static final long serialVersionUID = -2117620485640801370L;
        final Observer<? super U> a;
        final Function<? super T, ? extends ObservableSource<? extends U>> b;
        final boolean c;
        final int d;
        final int e;
        volatile SimplePlainQueue<U> f;
        volatile boolean g;
        final AtomicThrowable h = new AtomicThrowable();
        volatile boolean i;
        final AtomicReference<InnerObserver<?, ?>[]> j;
        Disposable k;
        long l;
        long m;
        int n;
        Queue<ObservableSource<? extends U>> o;
        int p;

        MergeObserver(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean z, int i, int i2) {
            this.a = observer;
            this.b = function;
            this.c = z;
            this.d = i;
            this.e = i2;
            if (i != Integer.MAX_VALUE) {
                this.o = new ArrayDeque(i);
            }
            this.j = new AtomicReference<>(q);
        }

        void a(ObservableSource<? extends U> observableSource) {
            ObservableSource<? extends U> poll;
            while (observableSource instanceof Callable) {
                if (!a((Callable) observableSource) || this.d == Integer.MAX_VALUE) {
                    return;
                }
                boolean z = false;
                synchronized (this) {
                    poll = this.o.poll();
                    if (poll == null) {
                        this.p--;
                        z = true;
                    }
                }
                if (z) {
                    c();
                    return;
                }
                observableSource = poll;
            }
            long j = this.l;
            this.l = 1 + j;
            InnerObserver<T, U> innerObserver = new InnerObserver<>(this, j);
            if (a(innerObserver)) {
                observableSource.subscribe(innerObserver);
            }
        }

        void a(U u, InnerObserver<T, U> innerObserver) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.a.onNext(u);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimpleQueue simpleQueue = innerObserver.d;
                if (simpleQueue == null) {
                    simpleQueue = new SpscLinkedArrayQueue(this.e);
                    innerObserver.d = simpleQueue;
                }
                simpleQueue.offer(u);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            d();
        }

        boolean a() {
            if (this.i) {
                return true;
            }
            Throwable th = this.h.get();
            if (this.c || th == null) {
                return false;
            }
            b();
            Throwable terminate = this.h.terminate();
            if (terminate != ExceptionHelper.TERMINATED) {
                this.a.onError(terminate);
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean a(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver[] innerObserverArr2;
            do {
                innerObserverArr = this.j.get();
                if (innerObserverArr == r) {
                    innerObserver.dispose();
                    return false;
                }
                int length = innerObserverArr.length;
                innerObserverArr2 = new InnerObserver[length + 1];
                System.arraycopy(innerObserverArr, 0, innerObserverArr2, 0, length);
                innerObserverArr2[length] = innerObserver;
            } while (!this.j.compareAndSet(innerObserverArr, innerObserverArr2));
            return true;
        }

        boolean a(Callable<? extends U> callable) {
            try {
                U call = callable.call();
                if (call == null) {
                    return true;
                }
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.a.onNext(call);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                } else {
                    SimplePlainQueue<U> simplePlainQueue = this.f;
                    if (simplePlainQueue == null) {
                        int i = this.d;
                        simplePlainQueue = i == Integer.MAX_VALUE ? new SpscLinkedArrayQueue<>(this.e) : new SpscArrayQueue(i);
                        this.f = simplePlainQueue;
                    }
                    if (!simplePlainQueue.offer(call)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return true;
                    }
                    if (getAndIncrement() != 0) {
                        return false;
                    }
                }
                d();
                return true;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.h.addThrowable(th);
                c();
                return true;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void b(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver<?, ?>[] innerObserverArr2;
            do {
                innerObserverArr = this.j.get();
                int length = innerObserverArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (innerObserverArr[i2] == innerObserver) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerObserverArr2 = q;
                } else {
                    InnerObserver<?, ?>[] innerObserverArr3 = new InnerObserver[length - 1];
                    System.arraycopy(innerObserverArr, 0, innerObserverArr3, 0, i);
                    System.arraycopy(innerObserverArr, i + 1, innerObserverArr3, i, (length - i) - 1);
                    innerObserverArr2 = innerObserverArr3;
                }
            } while (!this.j.compareAndSet(innerObserverArr, innerObserverArr2));
        }

        boolean b() {
            InnerObserver<?, ?>[] andSet;
            this.k.dispose();
            InnerObserver<?, ?>[] innerObserverArr = this.j.get();
            InnerObserver<?, ?>[] innerObserverArr2 = r;
            if (innerObserverArr == innerObserverArr2 || (andSet = this.j.getAndSet(innerObserverArr2)) == r) {
                return false;
            }
            for (InnerObserver<?, ?> innerObserver : andSet) {
                innerObserver.dispose();
            }
            return true;
        }

        void c() {
            if (getAndIncrement() == 0) {
                d();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:75:0x00d1  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x00d0 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:80:0x00d6  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x00fb A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void d() {
            /*
                Method dump skipped, instructions count: 305
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableFlatMap.MergeObserver.d():void");
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Throwable terminate;
            if (this.i) {
                return;
            }
            this.i = true;
            if (!b() || (terminate = this.h.terminate()) == null || terminate == ExceptionHelper.TERMINATED) {
                return;
            }
            RxJavaPlugins.onError(terminate);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.i;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.g) {
                return;
            }
            this.g = true;
            c();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.g) {
                RxJavaPlugins.onError(th);
            } else if (!this.h.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.g = true;
                c();
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.g) {
                return;
            }
            try {
                ObservableSource<? extends U> observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.b.apply(t), "The mapper returned a null ObservableSource");
                if (this.d != Integer.MAX_VALUE) {
                    synchronized (this) {
                        if (this.p == this.d) {
                            this.o.offer(observableSource);
                            return;
                        }
                        this.p++;
                    }
                }
                a(observableSource);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.k.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.k, disposable)) {
                this.k = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean z, int i, int i2) {
        super(observableSource);
        this.b = function;
        this.c = z;
        this.d = i;
        this.e = i2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super U> observer) {
        if (ObservableScalarXMap.tryScalarXMapSubscribe(this.a, observer, this.b)) {
            return;
        }
        this.a.subscribe(new MergeObserver(observer, this.b, this.c, this.d, this.e));
    }
}
