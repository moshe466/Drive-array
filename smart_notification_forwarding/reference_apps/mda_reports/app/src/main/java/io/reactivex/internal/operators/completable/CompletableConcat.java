package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* loaded from: classes.dex */
public final class CompletableConcat extends Completable {
    final Publisher<? extends CompletableSource> a;
    final int b;

    /* loaded from: classes.dex */
    static final class CompletableConcatSubscriber extends AtomicInteger implements FlowableSubscriber<CompletableSource>, Disposable {
        private static final long serialVersionUID = 9032184911934499404L;
        final CompletableObserver a;
        final int b;
        final int c;
        final ConcatInnerObserver d = new ConcatInnerObserver(this);
        final AtomicBoolean e = new AtomicBoolean();
        int f;
        int g;
        SimpleQueue<CompletableSource> h;
        Subscription i;
        volatile boolean j;
        volatile boolean k;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static final class ConcatInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -5454794857847146511L;
            final CompletableConcatSubscriber a;

            ConcatInnerObserver(CompletableConcatSubscriber completableConcatSubscriber) {
                this.a = completableConcatSubscriber;
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

        CompletableConcatSubscriber(CompletableObserver completableObserver, int i) {
            this.a = completableObserver;
            this.b = i;
            this.c = i - (i >> 2);
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!isDisposed()) {
                if (!this.k) {
                    boolean z = this.j;
                    try {
                        CompletableSource poll = this.h.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            if (this.e.compareAndSet(false, true)) {
                                this.a.onComplete();
                                return;
                            }
                            return;
                        } else if (!z2) {
                            this.k = true;
                            poll.subscribe(this.d);
                            c();
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        a(th);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        void a(Throwable th) {
            if (!this.e.compareAndSet(false, true)) {
                RxJavaPlugins.onError(th);
            } else {
                this.i.cancel();
                this.a.onError(th);
            }
        }

        void b() {
            this.k = false;
            a();
        }

        void c() {
            if (this.f != 1) {
                int i = this.g + 1;
                if (i != this.c) {
                    this.g = i;
                } else {
                    this.g = 0;
                    this.i.request(i);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.i.cancel();
            DisposableHelper.dispose(this.d);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.d.get());
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.j = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.e.compareAndSet(false, true)) {
                RxJavaPlugins.onError(th);
            } else {
                DisposableHelper.dispose(this.d);
                this.a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(CompletableSource completableSource) {
            if (this.f != 0 || this.h.offer(completableSource)) {
                a();
            } else {
                onError(new MissingBackpressureException());
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.i, subscription)) {
                this.i = subscription;
                int i = this.b;
                long j = i == Integer.MAX_VALUE ? Long.MAX_VALUE : i;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.f = requestFusion;
                        this.h = queueSubscription;
                        this.j = true;
                        this.a.onSubscribe(this);
                        a();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.f = requestFusion;
                        this.h = queueSubscription;
                        this.a.onSubscribe(this);
                        subscription.request(j);
                        return;
                    }
                }
                int i2 = this.b;
                if (i2 == Integer.MAX_VALUE) {
                    this.h = new SpscLinkedArrayQueue(Flowable.bufferSize());
                } else {
                    this.h = new SpscArrayQueue(i2);
                }
                this.a.onSubscribe(this);
                subscription.request(j);
            }
        }
    }

    public CompletableConcat(Publisher<? extends CompletableSource> publisher, int i) {
        this.a = publisher;
        this.b = i;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        this.a.subscribe(new CompletableConcatSubscriber(completableObserver, this.b));
    }
}
