package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableRefCount<T> extends Flowable<T> {
    final ConnectableFlowable<T> b;
    final int c;
    final long d;
    final TimeUnit e;
    final Scheduler f;
    RefConnection g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        private static final long serialVersionUID = -4552101107598366241L;
        final FlowableRefCount<?> a;
        Disposable b;
        long c;
        boolean d;

        RefConnection(FlowableRefCount<?> flowableRefCount) {
            this.a = flowableRefCount;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.c(this);
        }
    }

    /* loaded from: classes2.dex */
    static final class RefCountSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -7419642935409022375L;
        final Subscriber<? super T> a;
        final FlowableRefCount<T> b;
        final RefConnection c;
        Subscription d;

        RefCountSubscriber(Subscriber<? super T> subscriber, FlowableRefCount<T> flowableRefCount, RefConnection refConnection) {
            this.a = subscriber;
            this.b = flowableRefCount;
            this.c = refConnection;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.d.cancel();
            if (compareAndSet(false, true)) {
                this.b.a(this.c);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.b.b(this.c);
                this.a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!compareAndSet(false, true)) {
                RxJavaPlugins.onError(th);
            } else {
                this.b.b(this.c);
                this.a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.d, subscription)) {
                this.d = subscription;
                this.a.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.d.request(j);
        }
    }

    public FlowableRefCount(ConnectableFlowable<T> connectableFlowable) {
        this(connectableFlowable, 1, 0L, TimeUnit.NANOSECONDS, Schedulers.trampoline());
    }

    public FlowableRefCount(ConnectableFlowable<T> connectableFlowable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.b = connectableFlowable;
        this.c = i;
        this.d = j;
        this.e = timeUnit;
        this.f = scheduler;
    }

    void a(RefConnection refConnection) {
        synchronized (this) {
            if (this.g == null) {
                return;
            }
            long j = refConnection.c - 1;
            refConnection.c = j;
            if (j == 0 && refConnection.d) {
                if (this.d == 0) {
                    c(refConnection);
                    return;
                }
                SequentialDisposable sequentialDisposable = new SequentialDisposable();
                refConnection.b = sequentialDisposable;
                sequentialDisposable.replace(this.f.scheduleDirect(refConnection, this.d, this.e));
            }
        }
    }

    void b(RefConnection refConnection) {
        synchronized (this) {
            if (this.g != null) {
                this.g = null;
                if (refConnection.b != null) {
                    refConnection.b.dispose();
                }
                if (this.b instanceof Disposable) {
                    ((Disposable) this.b).dispose();
                }
            }
        }
    }

    void c(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.c == 0 && refConnection == this.g) {
                this.g = null;
                DisposableHelper.dispose(refConnection);
                if (this.b instanceof Disposable) {
                    ((Disposable) this.b).dispose();
                }
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        RefConnection refConnection;
        boolean z;
        synchronized (this) {
            refConnection = this.g;
            if (refConnection == null) {
                refConnection = new RefConnection(this);
                this.g = refConnection;
            }
            long j = refConnection.c;
            if (j == 0 && refConnection.b != null) {
                refConnection.b.dispose();
            }
            long j2 = j + 1;
            refConnection.c = j2;
            z = true;
            if (refConnection.d || j2 != this.c) {
                z = false;
            } else {
                refConnection.d = true;
            }
        }
        this.b.subscribe((FlowableSubscriber) new RefCountSubscriber(subscriber, this, refConnection));
        if (z) {
            this.b.connect(refConnection);
        }
    }
}
