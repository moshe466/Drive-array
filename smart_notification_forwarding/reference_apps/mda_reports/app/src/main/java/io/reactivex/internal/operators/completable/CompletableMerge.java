package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* loaded from: classes.dex */
public final class CompletableMerge extends Completable {
    final Publisher<? extends CompletableSource> a;
    final int b;
    final boolean c;

    /* loaded from: classes.dex */
    static final class CompletableMergeSubscriber extends AtomicInteger implements FlowableSubscriber<CompletableSource>, Disposable {
        private static final long serialVersionUID = -2108443387387077490L;
        final CompletableObserver a;
        final int b;
        final boolean c;
        Subscription f;
        final CompositeDisposable e = new CompositeDisposable();
        final AtomicThrowable d = new AtomicThrowable();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public final class MergeInnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            private static final long serialVersionUID = 251330541679988317L;

            MergeInnerObserver() {
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
                CompletableMergeSubscriber.this.a(this);
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                CompletableMergeSubscriber.this.a(this, th);
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        CompletableMergeSubscriber(CompletableObserver completableObserver, int i, boolean z) {
            this.a = completableObserver;
            this.b = i;
            this.c = z;
            lazySet(1);
        }

        void a(MergeInnerObserver mergeInnerObserver) {
            this.e.delete(mergeInnerObserver);
            if (decrementAndGet() != 0) {
                if (this.b != Integer.MAX_VALUE) {
                    this.f.request(1L);
                }
            } else {
                Throwable th = this.d.get();
                if (th != null) {
                    this.a.onError(th);
                } else {
                    this.a.onComplete();
                }
            }
        }

        void a(MergeInnerObserver mergeInnerObserver, Throwable th) {
            this.e.delete(mergeInnerObserver);
            if (!this.c) {
                this.f.cancel();
                this.e.dispose();
                if (this.d.addThrowable(th)) {
                    if (getAndSet(0) <= 0) {
                        return;
                    }
                    this.a.onError(this.d.terminate());
                    return;
                }
                RxJavaPlugins.onError(th);
            }
            if (this.d.addThrowable(th)) {
                if (decrementAndGet() != 0) {
                    if (this.b != Integer.MAX_VALUE) {
                        this.f.request(1L);
                        return;
                    }
                    return;
                }
                this.a.onError(this.d.terminate());
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f.cancel();
            this.e.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.e.isDisposed();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (decrementAndGet() == 0) {
                if (this.d.get() != null) {
                    this.a.onError(this.d.terminate());
                } else {
                    this.a.onComplete();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.c) {
                if (this.d.addThrowable(th)) {
                    if (decrementAndGet() != 0) {
                        return;
                    }
                    this.a.onError(this.d.terminate());
                    return;
                }
                RxJavaPlugins.onError(th);
            }
            this.e.dispose();
            if (this.d.addThrowable(th)) {
                if (getAndSet(0) <= 0) {
                    return;
                }
                this.a.onError(this.d.terminate());
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(CompletableSource completableSource) {
            getAndIncrement();
            MergeInnerObserver mergeInnerObserver = new MergeInnerObserver();
            this.e.add(mergeInnerObserver);
            completableSource.subscribe(mergeInnerObserver);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f, subscription)) {
                this.f = subscription;
                this.a.onSubscribe(this);
                int i = this.b;
                subscription.request(i == Integer.MAX_VALUE ? Long.MAX_VALUE : i);
            }
        }
    }

    public CompletableMerge(Publisher<? extends CompletableSource> publisher, int i, boolean z) {
        this.a = publisher;
        this.b = i;
        this.c = z;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe(new CompletableMergeSubscriber(completableObserver, this.b, this.c));
    }
}
