package io.reactivex.internal.operators.observable;

import android.R;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableConcatMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    final Function<? super T, ? extends ObservableSource<? extends U>> b;
    final int c;
    final ErrorMode d;

    /* loaded from: classes3.dex */
    static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -6951100001833242599L;
        final Observer<? super R> a;
        final Function<? super T, ? extends ObservableSource<? extends R>> b;
        final int c;
        final AtomicThrowable d = new AtomicThrowable();
        final DelayErrorInnerObserver<R> e;
        final boolean f;
        SimpleQueue<T> g;
        Disposable h;
        volatile boolean i;
        volatile boolean j;
        volatile boolean k;
        int l;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static final class DelayErrorInnerObserver<R> extends AtomicReference<Disposable> implements Observer<R> {
            private static final long serialVersionUID = 2620149119579502636L;
            final Observer<? super R> a;
            final ConcatMapDelayErrorObserver<?, R> b;

            DelayErrorInnerObserver(Observer<? super R> observer, ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver) {
                this.a = observer;
                this.b = concatMapDelayErrorObserver;
            }

            void a() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.b;
                concatMapDelayErrorObserver.i = false;
                concatMapDelayErrorObserver.a();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.b;
                if (!concatMapDelayErrorObserver.d.addThrowable(th)) {
                    RxJavaPlugins.onError(th);
                    return;
                }
                if (!concatMapDelayErrorObserver.f) {
                    concatMapDelayErrorObserver.h.dispose();
                }
                concatMapDelayErrorObserver.i = false;
                concatMapDelayErrorObserver.a();
            }

            @Override // io.reactivex.Observer
            public void onNext(R r) {
                this.a.onNext(r);
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        ConcatMapDelayErrorObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i, boolean z) {
            this.a = observer;
            this.b = function;
            this.c = i;
            this.f = z;
            this.e = new DelayErrorInnerObserver<>(observer, this);
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super R> observer = this.a;
            SimpleQueue<T> simpleQueue = this.g;
            AtomicThrowable atomicThrowable = this.d;
            while (true) {
                if (!this.i) {
                    if (!this.k) {
                        if (!this.f && atomicThrowable.get() != null) {
                            simpleQueue.clear();
                            this.k = true;
                            break;
                        }
                        boolean z = this.j;
                        try {
                            T poll = simpleQueue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.k = true;
                                Throwable terminate = atomicThrowable.terminate();
                                if (terminate != null) {
                                    observer.onError(terminate);
                                    return;
                                } else {
                                    observer.onComplete();
                                    return;
                                }
                            }
                            if (!z2) {
                                try {
                                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.b.apply(poll), "The mapper returned a null ObservableSource");
                                    if (observableSource instanceof Callable) {
                                        try {
                                            R.attr attrVar = (Object) ((Callable) observableSource).call();
                                            if (attrVar != null && !this.k) {
                                                observer.onNext(attrVar);
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.throwIfFatal(th);
                                            atomicThrowable.addThrowable(th);
                                        }
                                    } else {
                                        this.i = true;
                                        observableSource.subscribe(this.e);
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    this.k = true;
                                    this.h.dispose();
                                    simpleQueue.clear();
                                    atomicThrowable.addThrowable(th2);
                                    observer.onError(atomicThrowable.terminate());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            this.k = true;
                            this.h.dispose();
                            atomicThrowable.addThrowable(th3);
                        }
                    } else {
                        simpleQueue.clear();
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.k = true;
            this.h.dispose();
            this.e.a();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.k;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.j = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.d.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.j = true;
                a();
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.l == 0) {
                this.g.offer(t);
            }
            a();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.h, disposable)) {
                this.h = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.l = requestFusion;
                        this.g = queueDisposable;
                        this.j = true;
                        this.a.onSubscribe(this);
                        a();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.l = requestFusion;
                        this.g = queueDisposable;
                        this.a.onSubscribe(this);
                        return;
                    }
                }
                this.g = new SpscLinkedArrayQueue(this.c);
                this.a.onSubscribe(this);
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class SourceObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8828587559905699186L;
        final Observer<? super U> a;
        final Function<? super T, ? extends ObservableSource<? extends U>> b;
        final InnerObserver<U> c;
        final int d;
        SimpleQueue<T> e;
        Disposable f;
        volatile boolean g;
        volatile boolean h;
        volatile boolean i;
        int j;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static final class InnerObserver<U> extends AtomicReference<Disposable> implements Observer<U> {
            private static final long serialVersionUID = -7449079488798789337L;
            final Observer<? super U> a;
            final SourceObserver<?, ?> b;

            InnerObserver(Observer<? super U> observer, SourceObserver<?, ?> sourceObserver) {
                this.a = observer;
                this.b = sourceObserver;
            }

            void a() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                this.b.b();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                this.b.dispose();
                this.a.onError(th);
            }

            @Override // io.reactivex.Observer
            public void onNext(U u) {
                this.a.onNext(u);
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.set(this, disposable);
            }
        }

        SourceObserver(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, int i) {
            this.a = observer;
            this.b = function;
            this.d = i;
            this.c = new InnerObserver<>(observer, this);
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.h) {
                if (!this.g) {
                    boolean z = this.i;
                    try {
                        T poll = this.e.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            this.h = true;
                            this.a.onComplete();
                            return;
                        } else if (!z2) {
                            try {
                                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.b.apply(poll), "The mapper returned a null ObservableSource");
                                this.g = true;
                                observableSource.subscribe(this.c);
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                dispose();
                                this.e.clear();
                                this.a.onError(th);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        dispose();
                        this.e.clear();
                        this.a.onError(th2);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.e.clear();
        }

        void b() {
            this.g = false;
            a();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.h = true;
            this.c.a();
            this.f.dispose();
            if (getAndIncrement() == 0) {
                this.e.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.h;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.i) {
                return;
            }
            this.i = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.i) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.i = true;
            dispose();
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.i) {
                return;
            }
            if (this.j == 0) {
                this.e.offer(t);
            }
            a();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.j = requestFusion;
                        this.e = queueDisposable;
                        this.i = true;
                        this.a.onSubscribe(this);
                        a();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.j = requestFusion;
                        this.e = queueDisposable;
                        this.a.onSubscribe(this);
                        return;
                    }
                }
                this.e = new SpscLinkedArrayQueue(this.d);
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, int i, ErrorMode errorMode) {
        super(observableSource);
        this.b = function;
        this.d = errorMode;
        this.c = Math.max(8, i);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super U> observer) {
        if (ObservableScalarXMap.tryScalarXMapSubscribe(this.a, observer, this.b)) {
            return;
        }
        ErrorMode errorMode = this.d;
        if (errorMode == ErrorMode.IMMEDIATE) {
            this.a.subscribe(new SourceObserver(new SerializedObserver(observer), this.b, this.c));
        } else {
            this.a.subscribe(new ConcatMapDelayErrorObserver(observer, this.b, this.c, errorMode == ErrorMode.END));
        }
    }
}
