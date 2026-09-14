package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableBufferBoundarySupplier<T, U extends Collection<? super T>, B> extends AbstractFlowableWithUpstream<T, U> {
    final Callable<? extends Publisher<B>> c;
    final Callable<U> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class BufferBoundarySubscriber<T, U extends Collection<? super T>, B> extends DisposableSubscriber<B> {
        final BufferBoundarySupplierSubscriber<T, U, B> b;
        boolean c;

        BufferBoundarySubscriber(BufferBoundarySupplierSubscriber<T, U, B> bufferBoundarySupplierSubscriber) {
            this.b = bufferBoundarySupplierSubscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.c) {
                return;
            }
            this.c = true;
            this.b.b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.c) {
                RxJavaPlugins.onError(th);
            } else {
                this.c = true;
                this.b.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(B b) {
            if (this.c) {
                return;
            }
            this.c = true;
            a();
            this.b.b();
        }
    }

    /* loaded from: classes2.dex */
    static final class BufferBoundarySupplierSubscriber<T, U extends Collection<? super T>, B> extends QueueDrainSubscriber<T, U, U> implements FlowableSubscriber<T>, Subscription, Disposable {
        final Callable<U> h;
        final Callable<? extends Publisher<B>> i;
        Subscription j;
        final AtomicReference<Disposable> k;
        U l;

        BufferBoundarySupplierSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, Callable<? extends Publisher<B>> callable2) {
            super(subscriber, new MpscLinkedQueue());
            this.k = new AtomicReference<>();
            this.h = callable;
            this.i = callable2;
        }

        void a() {
            DisposableHelper.dispose(this.k);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public /* bridge */ /* synthetic */ boolean accept(Subscriber subscriber, Object obj) {
            return accept((Subscriber<? super Subscriber>) subscriber, (Subscriber) obj);
        }

        public boolean accept(Subscriber<? super U> subscriber, U u) {
            this.c.onNext(u);
            return true;
        }

        void b() {
            U u;
            try {
                u = (U) ObjectHelper.requireNonNull(this.h.call(), "The buffer supplied is null");
            } catch (Throwable th) {
                th = th;
                Exceptions.throwIfFatal(th);
                cancel();
            }
            try {
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.i.call(), "The boundary publisher supplied is null");
                BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(this);
                if (DisposableHelper.replace(this.k, bufferBoundarySubscriber)) {
                    synchronized (this) {
                        U u2 = this.l;
                        if (u2 == null) {
                            return;
                        }
                        this.l = u;
                        publisher.subscribe(bufferBoundarySubscriber);
                        a(u2, false, this);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                Exceptions.throwIfFatal(th);
                this.e = true;
                this.j.cancel();
                this.c.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.e) {
                return;
            }
            this.e = true;
            this.j.cancel();
            a();
            if (enter()) {
                this.d.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.j.cancel();
            a();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.k.get() == DisposableHelper.DISPOSED;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            synchronized (this) {
                U u = this.l;
                if (u == null) {
                    return;
                }
                this.l = null;
                this.d.offer(u);
                this.f = true;
                if (enter()) {
                    QueueDrainHelper.drainMaxLoop(this.d, this.c, false, this, this);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            cancel();
            this.c.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            synchronized (this) {
                U u = this.l;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.j, subscription)) {
                this.j = subscription;
                Subscriber<? super V> subscriber = this.c;
                try {
                    this.l = (U) ObjectHelper.requireNonNull(this.h.call(), "The buffer supplied is null");
                    Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.i.call(), "The boundary publisher supplied is null");
                    BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(this);
                    this.k.set(bufferBoundarySubscriber);
                    subscriber.onSubscribe(this);
                    if (this.e) {
                        return;
                    }
                    subscription.request(Long.MAX_VALUE);
                    publisher.subscribe(bufferBoundarySubscriber);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.e = true;
                    subscription.cancel();
                    EmptySubscription.error(th, subscriber);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }
    }

    public FlowableBufferBoundarySupplier(Flowable<T> flowable, Callable<? extends Publisher<B>> callable, Callable<U> callable2) {
        super(flowable);
        this.c = callable;
        this.d = callable2;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super U> subscriber) {
        this.b.subscribe((FlowableSubscriber) new BufferBoundarySupplierSubscriber(new SerializedSubscriber(subscriber), this.d, this.c));
    }
}
