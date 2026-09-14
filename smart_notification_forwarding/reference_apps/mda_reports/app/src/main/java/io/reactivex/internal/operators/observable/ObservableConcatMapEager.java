package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.observers.InnerQueuedObserverSupport;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class ObservableConcatMapEager<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super T, ? extends ObservableSource<? extends R>> b;
    final ErrorMode c;
    final int d;
    final int e;

    /* loaded from: classes3.dex */
    static final class ConcatMapEagerMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable, InnerQueuedObserverSupport<R> {
        private static final long serialVersionUID = 8080567949447303262L;
        final Observer<? super R> a;
        final Function<? super T, ? extends ObservableSource<? extends R>> b;
        final int c;
        final int d;
        final ErrorMode e;
        final AtomicThrowable f = new AtomicThrowable();
        final ArrayDeque<InnerQueuedObserver<R>> g = new ArrayDeque<>();
        SimpleQueue<T> h;
        Disposable i;
        volatile boolean j;
        int k;
        volatile boolean l;
        InnerQueuedObserver<R> m;
        int n;

        ConcatMapEagerMainObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i, int i2, ErrorMode errorMode) {
            this.a = observer;
            this.b = function;
            this.c = i;
            this.d = i2;
            this.e = errorMode;
        }

        void a() {
            InnerQueuedObserver<R> innerQueuedObserver = this.m;
            if (innerQueuedObserver != null) {
                innerQueuedObserver.dispose();
            }
            while (true) {
                InnerQueuedObserver<R> poll = this.g.poll();
                if (poll == null) {
                    return;
                } else {
                    poll.dispose();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.l = true;
            if (getAndIncrement() == 0) {
                this.h.clear();
                a();
            }
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void drain() {
            R poll;
            boolean z;
            if (getAndIncrement() != 0) {
                return;
            }
            SimpleQueue<T> simpleQueue = this.h;
            ArrayDeque<InnerQueuedObserver<R>> arrayDeque = this.g;
            Observer<? super R> observer = this.a;
            ErrorMode errorMode = this.e;
            int i = 1;
            while (true) {
                int i2 = this.n;
                while (i2 != this.c) {
                    if (this.l) {
                        simpleQueue.clear();
                        a();
                        return;
                    }
                    if (errorMode == ErrorMode.IMMEDIATE && this.f.get() != null) {
                        simpleQueue.clear();
                        a();
                        observer.onError(this.f.terminate());
                        return;
                    }
                    try {
                        T poll2 = simpleQueue.poll();
                        if (poll2 == null) {
                            break;
                        }
                        ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.b.apply(poll2), "The mapper returned a null ObservableSource");
                        InnerQueuedObserver<R> innerQueuedObserver = new InnerQueuedObserver<>(this, this.d);
                        arrayDeque.offer(innerQueuedObserver);
                        observableSource.subscribe(innerQueuedObserver);
                        i2++;
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.i.dispose();
                        simpleQueue.clear();
                        a();
                        this.f.addThrowable(th);
                        observer.onError(this.f.terminate());
                        return;
                    }
                }
                this.n = i2;
                if (this.l) {
                    simpleQueue.clear();
                    a();
                    return;
                }
                if (errorMode == ErrorMode.IMMEDIATE && this.f.get() != null) {
                    simpleQueue.clear();
                    a();
                    observer.onError(this.f.terminate());
                    return;
                }
                InnerQueuedObserver<R> innerQueuedObserver2 = this.m;
                if (innerQueuedObserver2 == null) {
                    if (errorMode == ErrorMode.BOUNDARY && this.f.get() != null) {
                        simpleQueue.clear();
                        a();
                        observer.onError(this.f.terminate());
                        return;
                    }
                    boolean z2 = this.j;
                    InnerQueuedObserver<R> poll3 = arrayDeque.poll();
                    boolean z3 = poll3 == null;
                    if (z2 && z3) {
                        if (this.f.get() == null) {
                            observer.onComplete();
                            return;
                        }
                        simpleQueue.clear();
                        a();
                        observer.onError(this.f.terminate());
                        return;
                    }
                    if (!z3) {
                        this.m = poll3;
                    }
                    innerQueuedObserver2 = poll3;
                }
                if (innerQueuedObserver2 != null) {
                    SimpleQueue<R> queue = innerQueuedObserver2.queue();
                    while (!this.l) {
                        boolean isDone = innerQueuedObserver2.isDone();
                        if (errorMode == ErrorMode.IMMEDIATE && this.f.get() != null) {
                            simpleQueue.clear();
                            a();
                            observer.onError(this.f.terminate());
                            return;
                        }
                        try {
                            poll = queue.poll();
                            z = poll == null;
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            this.f.addThrowable(th2);
                        }
                        if (isDone && z) {
                            this.m = null;
                            this.n--;
                        } else if (!z) {
                            observer.onNext(poll);
                        }
                    }
                    simpleQueue.clear();
                    a();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void innerComplete(InnerQueuedObserver<R> innerQueuedObserver) {
            innerQueuedObserver.setDone();
            drain();
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void innerError(InnerQueuedObserver<R> innerQueuedObserver, Throwable th) {
            if (!this.f.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (this.e == ErrorMode.IMMEDIATE) {
                this.i.dispose();
            }
            innerQueuedObserver.setDone();
            drain();
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void innerNext(InnerQueuedObserver<R> innerQueuedObserver, R r) {
            innerQueuedObserver.queue().offer(r);
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.l;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.j = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.f.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.j = true;
                drain();
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.k == 0) {
                this.h.offer(t);
            }
            drain();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.i, disposable)) {
                this.i = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.k = requestFusion;
                        this.h = queueDisposable;
                        this.j = true;
                        this.a.onSubscribe(this);
                        drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.k = requestFusion;
                        this.h = queueDisposable;
                        this.a.onSubscribe(this);
                        return;
                    }
                }
                this.h = new SpscLinkedArrayQueue(this.d);
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapEager(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, ErrorMode errorMode, int i, int i2) {
        super(observableSource);
        this.b = function;
        this.c = errorMode;
        this.d = i;
        this.e = i2;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        this.a.subscribe(new ConcatMapEagerMainObserver(observer, this.b, this.d, this.e, this.c));
    }
}
