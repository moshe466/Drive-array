package io.reactivex.internal.operators.mixed;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

@Experimental
/* loaded from: classes2.dex */
public final class FlowableConcatMapCompletable<T> extends Completable {
    final Flowable<T> a;
    final Function<? super T, ? extends CompletableSource> b;
    final ErrorMode c;
    final int d;

    /* loaded from: classes2.dex */
    static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        private static final long serialVersionUID = 3610901111000061034L;
        final CompletableObserver a;
        final Function<? super T, ? extends CompletableSource> b;
        final ErrorMode c;
        final AtomicThrowable d = new AtomicThrowable();
        final ConcatMapInnerObserver e = new ConcatMapInnerObserver(this);
        final int f;
        final SimplePlainQueue<T> g;
        Subscription h;
        volatile boolean i;
        volatile boolean j;
        volatile boolean k;
        int l;

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
            this.g = new SpscArrayQueue(i);
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.k) {
                if (!this.i) {
                    if (this.c == ErrorMode.BOUNDARY && this.d.get() != null) {
                        this.g.clear();
                        this.a.onError(this.d.terminate());
                        return;
                    }
                    boolean z = this.j;
                    T poll = this.g.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        Throwable terminate = this.d.terminate();
                        if (terminate != null) {
                            this.a.onError(terminate);
                            return;
                        } else {
                            this.a.onComplete();
                            return;
                        }
                    }
                    if (!z2) {
                        int i = this.f;
                        int i2 = i - (i >> 1);
                        int i3 = this.l + 1;
                        if (i3 == i2) {
                            this.l = 0;
                            this.h.request(i2);
                        } else {
                            this.l = i3;
                        }
                        try {
                            CompletableSource completableSource = (CompletableSource) ObjectHelper.requireNonNull(this.b.apply(poll), "The mapper returned a null CompletableSource");
                            this.i = true;
                            completableSource.subscribe(this.e);
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.g.clear();
                            this.h.cancel();
                            this.d.addThrowable(th);
                            this.a.onError(this.d.terminate());
                            return;
                        }
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
            this.h.cancel();
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
            this.h.cancel();
            this.e.a();
            if (getAndIncrement() == 0) {
                this.g.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.k;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.j = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
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
            this.e.a();
            Throwable terminate = this.d.terminate();
            if (terminate != ExceptionHelper.TERMINATED) {
                this.a.onError(terminate);
            }
            if (getAndIncrement() == 0) {
                this.g.clear();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.g.offer(t)) {
                a();
            } else {
                this.h.cancel();
                onError(new MissingBackpressureException("Queue full?!"));
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.h, subscription)) {
                this.h = subscription;
                this.a.onSubscribe(this);
                subscription.request(this.f);
            }
        }
    }

    public FlowableConcatMapCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i) {
        this.a = flowable;
        this.b = function;
        this.c = errorMode;
        this.d = i;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe((FlowableSubscriber) new ConcatMapCompletableObserver(completableObserver, this.b, this.c, this.d));
    }
}
