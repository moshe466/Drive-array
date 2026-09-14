package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class MaybeConcatArrayDelayError<T> extends Flowable<T> {
    final MaybeSource<? extends T>[] b;

    /* loaded from: classes2.dex */
    static final class ConcatMaybeObserver<T> extends AtomicInteger implements MaybeObserver<T>, Subscription {
        private static final long serialVersionUID = 3520831347801429610L;
        final Subscriber<? super T> a;
        final MaybeSource<? extends T>[] e;
        int g;
        long h;
        final AtomicLong b = new AtomicLong();
        final SequentialDisposable d = new SequentialDisposable();
        final AtomicReference<Object> c = new AtomicReference<>(NotificationLite.COMPLETE);
        final AtomicThrowable f = new AtomicThrowable();

        ConcatMaybeObserver(Subscriber<? super T> subscriber, MaybeSource<? extends T>[] maybeSourceArr) {
            this.a = subscriber;
            this.e = maybeSourceArr;
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicReference<Object> atomicReference = this.c;
            Subscriber<? super T> subscriber = this.a;
            SequentialDisposable sequentialDisposable = this.d;
            while (!sequentialDisposable.isDisposed()) {
                Object obj = atomicReference.get();
                if (obj != null) {
                    boolean z = true;
                    if (obj != NotificationLite.COMPLETE) {
                        long j = this.h;
                        if (j != this.b.get()) {
                            this.h = j + 1;
                            atomicReference.lazySet(null);
                            subscriber.onNext(obj);
                        } else {
                            z = false;
                        }
                    } else {
                        atomicReference.lazySet(null);
                    }
                    if (z && !sequentialDisposable.isDisposed()) {
                        int i = this.g;
                        MaybeSource<? extends T>[] maybeSourceArr = this.e;
                        if (i == maybeSourceArr.length) {
                            if (this.f.get() != null) {
                                subscriber.onError(this.f.terminate());
                                return;
                            } else {
                                subscriber.onComplete();
                                return;
                            }
                        }
                        this.g = i + 1;
                        maybeSourceArr[i].subscribe(this);
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            atomicReference.lazySet(null);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.d.dispose();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.c.lazySet(NotificationLite.COMPLETE);
            a();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.c.lazySet(NotificationLite.COMPLETE);
            if (this.f.addThrowable(th)) {
                a();
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            this.d.replace(disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.c.lazySet(t);
            a();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.b, j);
                a();
            }
        }
    }

    public MaybeConcatArrayDelayError(MaybeSource<? extends T>[] maybeSourceArr) {
        this.b = maybeSourceArr;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        ConcatMaybeObserver concatMaybeObserver = new ConcatMaybeObserver(subscriber, this.b);
        subscriber.onSubscribe(concatMaybeObserver);
        concatMaybeObserver.a();
    }
}
