package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqual;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;

/* loaded from: classes2.dex */
public final class FlowableSequenceEqualSingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {
    final Publisher<? extends T> a;
    final Publisher<? extends T> b;
    final BiPredicate<? super T, ? super T> c;
    final int d;

    /* loaded from: classes2.dex */
    static final class EqualCoordinator<T> extends AtomicInteger implements Disposable, FlowableSequenceEqual.EqualCoordinatorHelper {
        private static final long serialVersionUID = -6178010334400373240L;
        final SingleObserver<? super Boolean> a;
        final BiPredicate<? super T, ? super T> b;
        final FlowableSequenceEqual.EqualSubscriber<T> c;
        final FlowableSequenceEqual.EqualSubscriber<T> d;
        final AtomicThrowable e = new AtomicThrowable();
        T f;
        T g;

        EqualCoordinator(SingleObserver<? super Boolean> singleObserver, int i, BiPredicate<? super T, ? super T> biPredicate) {
            this.a = singleObserver;
            this.b = biPredicate;
            this.c = new FlowableSequenceEqual.EqualSubscriber<>(this, i);
            this.d = new FlowableSequenceEqual.EqualSubscriber<>(this, i);
        }

        void a() {
            this.c.cancel();
            this.c.a();
            this.d.cancel();
            this.d.a();
        }

        void a(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
            publisher.subscribe(this.c);
            publisher2.subscribe(this.d);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.c.cancel();
            this.d.cancel();
            if (getAndIncrement() == 0) {
                this.c.a();
                this.d.a();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinatorHelper
        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            int i = 1;
            do {
                SimpleQueue<T> simpleQueue = this.c.e;
                SimpleQueue<T> simpleQueue2 = this.d.e;
                if (simpleQueue != null && simpleQueue2 != null) {
                    while (!isDisposed()) {
                        if (this.e.get() != null) {
                            a();
                            this.a.onError(this.e.terminate());
                            return;
                        }
                        boolean z = this.c.f;
                        T t = this.f;
                        if (t == null) {
                            try {
                                t = simpleQueue.poll();
                                this.f = t;
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                a();
                                this.e.addThrowable(th);
                                this.a.onError(this.e.terminate());
                                return;
                            }
                        }
                        boolean z2 = t == null;
                        boolean z3 = this.d.f;
                        T t2 = this.g;
                        if (t2 == null) {
                            try {
                                t2 = simpleQueue2.poll();
                                this.g = t2;
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                a();
                                this.e.addThrowable(th2);
                                this.a.onError(this.e.terminate());
                                return;
                            }
                        }
                        boolean z4 = t2 == null;
                        if (z && z3 && z2 && z4) {
                            this.a.onSuccess(true);
                            return;
                        }
                        if (z && z3 && z2 != z4) {
                            a();
                            this.a.onSuccess(false);
                            return;
                        }
                        if (!z2 && !z4) {
                            try {
                                if (!this.b.test(t, t2)) {
                                    a();
                                    this.a.onSuccess(false);
                                    return;
                                } else {
                                    this.f = null;
                                    this.g = null;
                                    this.c.request();
                                    this.d.request();
                                }
                            } catch (Throwable th3) {
                                Exceptions.throwIfFatal(th3);
                                a();
                                this.e.addThrowable(th3);
                                this.a.onError(this.e.terminate());
                                return;
                            }
                        }
                    }
                    this.c.a();
                    this.d.a();
                    return;
                }
                if (isDisposed()) {
                    this.c.a();
                    this.d.a();
                    return;
                } else if (this.e.get() != null) {
                    a();
                    this.a.onError(this.e.terminate());
                    return;
                }
                i = addAndGet(-i);
            } while (i != 0);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinatorHelper
        public void innerError(Throwable th) {
            if (this.e.addThrowable(th)) {
                drain();
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return SubscriptionHelper.isCancelled(this.c.get());
        }
    }

    public FlowableSequenceEqualSingle(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, BiPredicate<? super T, ? super T> biPredicate, int i) {
        this.a = publisher;
        this.b = publisher2;
        this.c = biPredicate;
        this.d = i;
    }

    @Override // io.reactivex.internal.fuseable.FuseToFlowable
    public Flowable<Boolean> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableSequenceEqual(this.a, this.b, this.c, this.d));
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.d, this.c);
        singleObserver.onSubscribe(equalCoordinator);
        equalCoordinator.a(this.a, this.b);
    }
}
