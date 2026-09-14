package io.reactivex.internal.operators.mixed;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

@Experimental
/* loaded from: classes2.dex */
public final class FlowableSwitchMapCompletable<T> extends Completable {
    final Flowable<T> a;
    final Function<? super T, ? extends CompletableSource> b;
    final boolean c;

    /* loaded from: classes2.dex */
    static final class SwitchMapCompletableObserver<T> implements FlowableSubscriber<T>, Disposable {
        static final SwitchMapInnerObserver h = new SwitchMapInnerObserver(null);
        final CompletableObserver a;
        final Function<? super T, ? extends CompletableSource> b;
        final boolean c;
        final AtomicThrowable d = new AtomicThrowable();
        final AtomicReference<SwitchMapInnerObserver> e = new AtomicReference<>();
        volatile boolean f;
        Subscription g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public static final class SwitchMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -8003404460084760287L;
            final SwitchMapCompletableObserver<?> a;

            SwitchMapInnerObserver(SwitchMapCompletableObserver<?> switchMapCompletableObserver) {
                this.a = switchMapCompletableObserver;
            }

            void a() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.a.a(this);
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                this.a.a(this, th);
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        SwitchMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z) {
            this.a = completableObserver;
            this.b = function;
            this.c = z;
        }

        void a() {
            SwitchMapInnerObserver andSet = this.e.getAndSet(h);
            if (andSet == null || andSet == h) {
                return;
            }
            andSet.a();
        }

        void a(SwitchMapInnerObserver switchMapInnerObserver) {
            if (this.e.compareAndSet(switchMapInnerObserver, null) && this.f) {
                Throwable terminate = this.d.terminate();
                if (terminate == null) {
                    this.a.onComplete();
                } else {
                    this.a.onError(terminate);
                }
            }
        }

        void a(SwitchMapInnerObserver switchMapInnerObserver, Throwable th) {
            Throwable terminate;
            if (!this.e.compareAndSet(switchMapInnerObserver, null) || !this.d.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (!this.c) {
                dispose();
                terminate = this.d.terminate();
                if (terminate == ExceptionHelper.TERMINATED) {
                    return;
                }
            } else if (!this.f) {
                return;
            } else {
                terminate = this.d.terminate();
            }
            this.a.onError(terminate);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.g.cancel();
            a();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.e.get() == h;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f = true;
            if (this.e.get() == null) {
                Throwable terminate = this.d.terminate();
                if (terminate == null) {
                    this.a.onComplete();
                } else {
                    this.a.onError(terminate);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.d.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (this.c) {
                onComplete();
                return;
            }
            a();
            Throwable terminate = this.d.terminate();
            if (terminate != ExceptionHelper.TERMINATED) {
                this.a.onError(terminate);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            SwitchMapInnerObserver switchMapInnerObserver;
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.requireNonNull(this.b.apply(t), "The mapper returned a null CompletableSource");
                SwitchMapInnerObserver switchMapInnerObserver2 = new SwitchMapInnerObserver(this);
                do {
                    switchMapInnerObserver = this.e.get();
                    if (switchMapInnerObserver == h) {
                        return;
                    }
                } while (!this.e.compareAndSet(switchMapInnerObserver, switchMapInnerObserver2));
                if (switchMapInnerObserver != null) {
                    switchMapInnerObserver.a();
                }
                completableSource.subscribe(switchMapInnerObserver2);
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
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableSwitchMapCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, boolean z) {
        this.a = flowable;
        this.b = function;
        this.c = z;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe((FlowableSubscriber) new SwitchMapCompletableObserver(completableObserver, this.b, this.c));
    }
}
