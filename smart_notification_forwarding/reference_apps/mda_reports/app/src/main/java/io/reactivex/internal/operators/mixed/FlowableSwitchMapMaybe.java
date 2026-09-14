package io.reactivex.internal.operators.mixed;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Experimental
/* loaded from: classes2.dex */
public final class FlowableSwitchMapMaybe<T, R> extends Flowable<R> {
    final Flowable<T> b;
    final Function<? super T, ? extends MaybeSource<? extends R>> c;
    final boolean d;

    /* loaded from: classes2.dex */
    static final class SwitchMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        static final SwitchMapMaybeObserver<Object> k = new SwitchMapMaybeObserver<>(null);
        private static final long serialVersionUID = -5402190102429853762L;
        final Subscriber<? super R> a;
        final Function<? super T, ? extends MaybeSource<? extends R>> b;
        final boolean c;
        final AtomicThrowable d = new AtomicThrowable();
        final AtomicLong e = new AtomicLong();
        final AtomicReference<SwitchMapMaybeObserver<R>> f = new AtomicReference<>();
        Subscription g;
        volatile boolean h;
        volatile boolean i;
        long j;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public static final class SwitchMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            final SwitchMapMaybeSubscriber<?, R> a;
            volatile R b;

            SwitchMapMaybeObserver(SwitchMapMaybeSubscriber<?, R> switchMapMaybeSubscriber) {
                this.a = switchMapMaybeSubscriber;
            }

            void a() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.a.a(this);
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                this.a.a(this, th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(R r) {
                this.b = r;
                this.a.b();
            }
        }

        SwitchMapMaybeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
            this.a = subscriber;
            this.b = function;
            this.c = z;
        }

        void a() {
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver = (SwitchMapMaybeObserver) this.f.getAndSet(k);
            if (switchMapMaybeObserver == null || switchMapMaybeObserver == k) {
                return;
            }
            switchMapMaybeObserver.a();
        }

        void a(SwitchMapMaybeObserver<R> switchMapMaybeObserver) {
            if (this.f.compareAndSet(switchMapMaybeObserver, null)) {
                b();
            }
        }

        void a(SwitchMapMaybeObserver<R> switchMapMaybeObserver, Throwable th) {
            if (!this.f.compareAndSet(switchMapMaybeObserver, null) || !this.d.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (!this.c) {
                this.g.cancel();
                a();
            }
            b();
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.a;
            AtomicThrowable atomicThrowable = this.d;
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.f;
            AtomicLong atomicLong = this.e;
            long j = this.j;
            int i = 1;
            while (!this.i) {
                if (atomicThrowable.get() != null && !this.c) {
                    subscriber.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z = this.h;
                SwitchMapMaybeObserver<R> switchMapMaybeObserver = atomicReference.get();
                boolean z2 = switchMapMaybeObserver == null;
                if (z && z2) {
                    Throwable terminate = atomicThrowable.terminate();
                    if (terminate != null) {
                        subscriber.onError(terminate);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                }
                if (z2 || switchMapMaybeObserver.b == null || j == atomicLong.get()) {
                    this.j = j;
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    atomicReference.compareAndSet(switchMapMaybeObserver, null);
                    subscriber.onNext(switchMapMaybeObserver.b);
                    j++;
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.i = true;
            this.g.cancel();
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.h = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.d.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (!this.c) {
                a();
            }
            this.h = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            SwitchMapMaybeObserver<R> switchMapMaybeObserver;
            SwitchMapMaybeObserver<R> switchMapMaybeObserver2 = this.f.get();
            if (switchMapMaybeObserver2 != null) {
                switchMapMaybeObserver2.a();
            }
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.requireNonNull(this.b.apply(t), "The mapper returned a null MaybeSource");
                SwitchMapMaybeObserver<R> switchMapMaybeObserver3 = new SwitchMapMaybeObserver<>(this);
                do {
                    switchMapMaybeObserver = this.f.get();
                    if (switchMapMaybeObserver == k) {
                        return;
                    }
                } while (!this.f.compareAndSet(switchMapMaybeObserver, switchMapMaybeObserver3));
                maybeSource.subscribe(switchMapMaybeObserver3);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.g.cancel();
                this.f.getAndSet(k);
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

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            BackpressureHelper.add(this.e, j);
            b();
        }
    }

    public FlowableSwitchMapMaybe(Flowable<T> flowable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        this.b = flowable;
        this.c = function;
        this.d = z;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe((FlowableSubscriber) new SwitchMapMaybeSubscriber(subscriber, this.c, this.d));
    }
}
