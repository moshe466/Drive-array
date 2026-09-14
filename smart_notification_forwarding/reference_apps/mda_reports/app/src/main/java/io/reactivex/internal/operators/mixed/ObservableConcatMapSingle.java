package io.reactivex.internal.operators.mixed;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Experimental
/* loaded from: classes2.dex */
public final class ObservableConcatMapSingle<T, R> extends Observable<R> {
    final Observable<T> a;
    final Function<? super T, ? extends SingleSource<? extends R>> b;
    final ErrorMode c;
    final int d;

    /* loaded from: classes2.dex */
    static final class ConcatMapSingleMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -9140123220065488293L;
        final Observer<? super R> a;
        final Function<? super T, ? extends SingleSource<? extends R>> b;
        final AtomicThrowable c = new AtomicThrowable();
        final ConcatMapSingleObserver<R> d = new ConcatMapSingleObserver<>(this);
        final SimplePlainQueue<T> e;
        final ErrorMode f;
        Disposable g;
        volatile boolean h;
        volatile boolean i;
        R j;
        volatile int k;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public static final class ConcatMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = -3051469169682093892L;
            final ConcatMapSingleMainObserver<?, R> a;

            ConcatMapSingleObserver(ConcatMapSingleMainObserver<?, R> concatMapSingleMainObserver) {
                this.a = concatMapSingleMainObserver;
            }

            void a() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                this.a.a(th);
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(R r) {
                this.a.a((ConcatMapSingleMainObserver<?, R>) r);
            }
        }

        ConcatMapSingleMainObserver(Observer<? super R> observer, Function<? super T, ? extends SingleSource<? extends R>> function, int i, ErrorMode errorMode) {
            this.a = observer;
            this.b = function;
            this.f = errorMode;
            this.e = new SpscLinkedArrayQueue(i);
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super R> observer = this.a;
            ErrorMode errorMode = this.f;
            SimplePlainQueue<T> simplePlainQueue = this.e;
            AtomicThrowable atomicThrowable = this.c;
            int i = 1;
            while (true) {
                if (this.i) {
                    simplePlainQueue.clear();
                    this.j = null;
                }
                int i2 = this.k;
                if (atomicThrowable.get() == null || (errorMode != ErrorMode.IMMEDIATE && (errorMode != ErrorMode.BOUNDARY || i2 != 0))) {
                    if (i2 == 0) {
                        boolean z = this.h;
                        T poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable terminate = atomicThrowable.terminate();
                            if (terminate == null) {
                                observer.onComplete();
                                return;
                            } else {
                                observer.onError(terminate);
                                return;
                            }
                        }
                        if (!z2) {
                            try {
                                SingleSource singleSource = (SingleSource) ObjectHelper.requireNonNull(this.b.apply(poll), "The mapper returned a null SingleSource");
                                this.k = 1;
                                singleSource.subscribe(this.d);
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                this.g.dispose();
                                simplePlainQueue.clear();
                                atomicThrowable.addThrowable(th);
                            }
                        }
                    } else if (i2 == 2) {
                        R r = this.j;
                        this.j = null;
                        observer.onNext(r);
                        this.k = 0;
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
                observer.onError(atomicThrowable.terminate());
            }
            simplePlainQueue.clear();
            this.j = null;
            observer.onError(atomicThrowable.terminate());
        }

        void a(R r) {
            this.j = r;
            this.k = 2;
            a();
        }

        void a(Throwable th) {
            if (!this.c.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (this.f != ErrorMode.END) {
                this.g.dispose();
            }
            this.k = 0;
            a();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.i = true;
            this.g.dispose();
            this.d.a();
            if (getAndIncrement() == 0) {
                this.e.clear();
                this.j = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.i;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.h = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.c.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (this.f == ErrorMode.IMMEDIATE) {
                this.d.a();
            }
            this.h = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.e.offer(t);
            a();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.g, disposable)) {
                this.g = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapSingle(Observable<T> observable, Function<? super T, ? extends SingleSource<? extends R>> function, ErrorMode errorMode, int i) {
        this.a = observable;
        this.b = function;
        this.c = errorMode;
        this.d = i;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        if (ScalarXMapZHelper.b(this.a, this.b, observer)) {
            return;
        }
        this.a.subscribe(new ConcatMapSingleMainObserver(observer, this.b, this.d, this.c));
    }
}
