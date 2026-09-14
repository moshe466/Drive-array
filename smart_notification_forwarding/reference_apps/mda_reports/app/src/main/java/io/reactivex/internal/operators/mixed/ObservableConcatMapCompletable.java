package io.reactivex.internal.operators.mixed;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.Experimental;
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
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Experimental
/* loaded from: classes2.dex */
public final class ObservableConcatMapCompletable<T> extends Completable {
    final Observable<T> a;
    final Function<? super T, ? extends CompletableSource> b;
    final ErrorMode c;
    final int d;

    /* loaded from: classes2.dex */
    static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 3610901111000061034L;
        final CompletableObserver a;
        final Function<? super T, ? extends CompletableSource> b;
        final ErrorMode c;
        final AtomicThrowable d = new AtomicThrowable();
        final ConcatMapInnerObserver e = new ConcatMapInnerObserver(this);
        final int f;
        SimpleQueue<T> g;
        Disposable h;
        volatile boolean i;
        volatile boolean j;
        volatile boolean k;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public static final class ConcatMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = 5638352172918776687L;
            final ConcatMapCompletableObserver<?> a;

            ConcatMapInnerObserver(ConcatMapCompletableObserver<?> concatMapCompletableObserver) {
                this.a = concatMapCompletableObserver;
            }

            void a() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.a.b();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                this.a.a(th);
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        ConcatMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i) {
            this.a = completableObserver;
            this.b = function;
            this.c = errorMode;
            this.f = i;
        }

        void a() {
            boolean z;
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicThrowable atomicThrowable = this.d;
            ErrorMode errorMode = this.c;
            while (!this.k) {
                if (!this.i) {
                    if (errorMode == ErrorMode.BOUNDARY && atomicThrowable.get() != null) {
                        this.k = true;
                        this.g.clear();
                        this.a.onError(atomicThrowable.terminate());
                        return;
                    }
                    boolean z2 = this.j;
                    CompletableSource completableSource = null;
                    try {
                        T poll = this.g.poll();
                        if (poll != null) {
                            completableSource = (CompletableSource) ObjectHelper.requireNonNull(this.b.apply(poll), "The mapper returned a null CompletableSource");
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z2 && z) {
                            this.k = true;
                            Throwable terminate = atomicThrowable.terminate();
                            if (terminate != null) {
                                this.a.onError(terminate);
                                return;
                            } else {
                                this.a.onComplete();
                                return;
                            }
                        }
                        if (!z) {
                            this.i = true;
                            completableSource.subscribe(this.e);
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.k = true;
                        this.g.clear();
                        this.h.dispose();
                        atomicThrowable.addThrowable(th);
                        this.a.onError(atomicThrowable.terminate());
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.g.clear();
        }

        void a(Throwable th) {
            if (!this.d.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (this.c != ErrorMode.IMMEDIATE) {
                this.i = false;
                a();
                return;
            }
            this.k = true;
            this.h.dispose();
            Throwable terminate = this.d.terminate();
            if (terminate != ExceptionHelper.TERMINATED) {
                this.a.onError(terminate);
            }
            if (getAndIncrement() == 0) {
                this.g.clear();
            }
        }

        void b() {
            this.i = false;
            a();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.k = true;
            this.h.dispose();
            this.e.a();
            if (getAndIncrement() == 0) {
                this.g.clear();
            }
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
                return;
            }
            if (this.c != ErrorMode.IMMEDIATE) {
                this.j = true;
                a();
                return;
            }
            this.k = true;
            this.e.a();
            Throwable terminate = this.d.terminate();
            if (terminate != ExceptionHelper.TERMINATED) {
                this.a.onError(terminate);
            }
            if (getAndIncrement() == 0) {
                this.g.clear();
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (t != null) {
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
                        this.g = queueDisposable;
                        this.j = true;
                        this.a.onSubscribe(this);
                        a();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.g = queueDisposable;
                        this.a.onSubscribe(this);
                        return;
                    }
                }
                this.g = new SpscLinkedArrayQueue(this.f);
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapCompletable(Observable<T> observable, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i) {
        this.a = observable;
        this.b = function;
        this.c = errorMode;
        this.d = i;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver completableObserver) {
        if (ScalarXMapZHelper.a(this.a, this.b, completableObserver)) {
            return;
        }
        this.a.subscribe(new ConcatMapCompletableObserver(completableObserver, this.b, this.c, this.d));
    }
}
