package io.reactivex.internal.operators.mixed;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
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
public final class FlowableSwitchMapSingle<T, R> extends Flowable<R> {
    final Flowable<T> b;
    final Function<? super T, ? extends SingleSource<? extends R>> c;
    final boolean d;

    /* loaded from: classes2.dex */
    static final class SwitchMapSingleSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        static final SwitchMapSingleObserver<Object> k = new SwitchMapSingleObserver<>(null);
        private static final long serialVersionUID = -5402190102429853762L;
        final Subscriber<? super R> a;
        final Function<? super T, ? extends SingleSource<? extends R>> b;
        final boolean c;
        final AtomicThrowable d = new AtomicThrowable();
        final AtomicLong e = new AtomicLong();
        final AtomicReference<SwitchMapSingleObserver<R>> f = new AtomicReference<>();
        Subscription g;
        volatile boolean h;
        volatile boolean i;
        long j;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public static final class SwitchMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            final SwitchMapSingleSubscriber<?, R> a;
            volatile R b;

            SwitchMapSingleObserver(SwitchMapSingleSubscriber<?, R> switchMapSingleSubscriber) {
                this.a = switchMapSingleSubscriber;
            }

            void a() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                this.a.a(this, th);
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(R r) {
                this.b = r;
                this.a.b();
            }
        }

        SwitchMapSingleSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
            this.a = subscriber;
            this.b = function;
            this.c = z;
        }

        void a() {
            SwitchMapSingleObserver<Object> switchMapSingleObserver = (SwitchMapSingleObserver) this.f.getAndSet(k);
            if (switchMapSingleObserver == null || switchMapSingleObserver == k) {
                return;
            }
            switchMapSingleObserver.a();
        }

        void a(SwitchMapSingleObserver<R> switchMapSingleObserver, Throwable th) {
            if (!this.f.compareAndSet(switchMapSingleObserver, null) || !this.d.addThrowable(th)) {
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
            AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.f;
            AtomicLong atomicLong = this.e;
            long j = this.j;
            int i = 1;
            while (!this.i) {
                if (atomicThrowable.get() != null && !this.c) {
                    subscriber.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z = this.h;
                SwitchMapSingleObserver<R> switchMapSingleObserver = atomicReference.get();
                boolean z2 = switchMapSingleObserver == null;
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
                if (z2 || switchMapSingleObserver.b == null || j == atomicLong.get()) {
                    this.j = j;
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    atomicReference.compareAndSet(switchMapSingleObserver, null);
                    subscriber.onNext(switchMapSingleObserver.b);
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
            SwitchMapSingleObserver<R> switchMapSingleObserver;
            SwitchMapSingleObserver<R> switchMapSingleObserver2 = this.f.get();
            if (switchMapSingleObserver2 != null) {
                switchMapSingleObserver2.a();
            }
            try {
                SingleSource singleSource = (SingleSource) ObjectHelper.requireNonNull(this.b.apply(t), "The mapper returned a null SingleSource");
                SwitchMapSingleObserver<R> switchMapSingleObserver3 = new SwitchMapSingleObserver<>(this);
                do {
                    switchMapSingleObserver = this.f.get();
                    if (switchMapSingleObserver == k) {
                        return;
                    }
                } while (!this.f.compareAndSet(switchMapSingleObserver, switchMapSingleObserver3));
                singleSource.subscribe(switchMapSingleObserver3);
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

    public FlowableSwitchMapSingle(Flowable<T> flowable, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        this.b = flowable;
        this.c = function;
        this.d = z;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe((FlowableSubscriber) new SwitchMapSingleSubscriber(subscriber, this.c, this.d));
    }
}
