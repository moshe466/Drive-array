package io.reactivex.internal.operators.flowable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableFlatMapCompletableCompletable<T> extends Completable implements FuseToFlowable<T> {
    final Flowable<T> a;
    final Function<? super T, ? extends CompletableSource> b;
    final int c;
    final boolean d;

    /* loaded from: classes2.dex */
    static final class FlatMapCompletableMainSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        private static final long serialVersionUID = 8443155186132538303L;
        final CompletableObserver a;
        final Function<? super T, ? extends CompletableSource> c;
        final boolean d;
        final int f;
        Subscription g;
        volatile boolean h;
        final AtomicThrowable b = new AtomicThrowable();
        final CompositeDisposable e = new CompositeDisposable();

        /* loaded from: classes2.dex */
        final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            private static final long serialVersionUID = 8606673141535671828L;

            InnerObserver() {
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                FlatMapCompletableMainSubscriber.this.a(this);
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                FlatMapCompletableMainSubscriber.this.a(this, th);
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        FlatMapCompletableMainSubscriber(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z, int i) {
            this.a = completableObserver;
            this.c = function;
            this.d = z;
            this.f = i;
            lazySet(1);
        }

        void a(FlatMapCompletableMainSubscriber<T>.InnerObserver innerObserver) {
            this.e.delete(innerObserver);
            onComplete();
        }

        void a(FlatMapCompletableMainSubscriber<T>.InnerObserver innerObserver, Throwable th) {
            this.e.delete(innerObserver);
            onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.h = true;
            this.g.cancel();
            this.e.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.e.isDisposed();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (decrementAndGet() != 0) {
                if (this.f != Integer.MAX_VALUE) {
                    this.g.request(1L);
                }
            } else {
                Throwable terminate = this.b.terminate();
                if (terminate != null) {
                    this.a.onError(terminate);
                } else {
                    this.a.onComplete();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.b.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (!this.d) {
                dispose();
                if (getAndSet(0) <= 0) {
                    return;
                }
            } else if (decrementAndGet() != 0) {
                if (this.f != Integer.MAX_VALUE) {
                    this.g.request(1L);
                    return;
                }
                return;
            }
            this.a.onError(this.b.terminate());
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.requireNonNull(this.c.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (this.h || !this.e.add(innerObserver)) {
                    return;
                }
                completableSource.subscribe(innerObserver);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.g.cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.g, subscription)) {
                this.g = subscription;
                this.a.onSubscribe(this);
                int i = this.f;
                subscription.request(i == Integer.MAX_VALUE ? Long.MAX_VALUE : i);
            }
        }
    }

    public FlowableFlatMapCompletableCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, boolean z, int i) {
        this.a = flowable;
        this.b = function;
        this.d = z;
        this.c = i;
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableFlatMapCompletable(this.a, this.b, this.d, this.c));
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe((FlowableSubscriber) new FlatMapCompletableMainSubscriber(completableObserver, this.b, this.d, this.c));
    }
}
