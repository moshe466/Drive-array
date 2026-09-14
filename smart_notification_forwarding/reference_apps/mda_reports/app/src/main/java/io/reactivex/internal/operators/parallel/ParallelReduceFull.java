package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes3.dex */
public final class ParallelReduceFull<T> extends Flowable<T> {
    final ParallelFlowable<? extends T> b;
    final BiFunction<T, T, T> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ParallelReduceFullInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7954444275102466525L;
        final ParallelReduceFullMainSubscriber<T> a;
        final BiFunction<T, T, T> b;
        T c;
        boolean d;

        ParallelReduceFullInnerSubscriber(ParallelReduceFullMainSubscriber<T> parallelReduceFullMainSubscriber, BiFunction<T, T, T> biFunction) {
            this.a = parallelReduceFullMainSubscriber;
            this.b = biFunction;
        }

        void a() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.d) {
                return;
            }
            this.d = true;
            this.a.b(this.c);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.onError(th);
            } else {
                this.d = true;
                this.a.innerError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.d) {
                return;
            }
            T t2 = this.c;
            if (t2 != null) {
                try {
                    t = (T) ObjectHelper.requireNonNull(this.b.apply(t2, t), "The reducer returned a null value");
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    get().cancel();
                    onError(th);
                    return;
                }
            }
            this.c = t;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ParallelReduceFullMainSubscriber<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = -5370107872170712765L;
        final ParallelReduceFullInnerSubscriber<T>[] c;
        final BiFunction<T, T, T> d;
        final AtomicReference<SlotPair<T>> e;
        final AtomicInteger f;
        final AtomicReference<Throwable> g;

        ParallelReduceFullMainSubscriber(Subscriber<? super T> subscriber, int i, BiFunction<T, T, T> biFunction) {
            super(subscriber);
            this.e = new AtomicReference<>();
            this.f = new AtomicInteger();
            this.g = new AtomicReference<>();
            ParallelReduceFullInnerSubscriber<T>[] parallelReduceFullInnerSubscriberArr = new ParallelReduceFullInnerSubscriber[i];
            for (int i2 = 0; i2 < i; i2++) {
                parallelReduceFullInnerSubscriberArr[i2] = new ParallelReduceFullInnerSubscriber<>(this, biFunction);
            }
            this.c = parallelReduceFullInnerSubscriberArr;
            this.d = biFunction;
            this.f.lazySet(i);
        }

        SlotPair<T> a(T t) {
            SlotPair<T> slotPair;
            int b;
            while (true) {
                slotPair = this.e.get();
                if (slotPair == null) {
                    slotPair = new SlotPair<>();
                    if (!this.e.compareAndSet(null, slotPair)) {
                        continue;
                    }
                }
                b = slotPair.b();
                if (b >= 0) {
                    break;
                }
                this.e.compareAndSet(slotPair, null);
            }
            if (b == 0) {
                slotPair.a = t;
            } else {
                slotPair.b = t;
            }
            if (!slotPair.a()) {
                return null;
            }
            this.e.compareAndSet(slotPair, null);
            return slotPair;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
        
            if (r2.f.decrementAndGet() != 0) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
        
            r3 = r2.e.get();
            r2.e.lazySet(null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0037, code lost:
        
            if (r3 == null) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        
            complete(r3.a);
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
        
            r2.a.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:1:0x0000, code lost:
        
            if (r3 != null) goto L3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
        
            r3 = a(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
        
            if (r3 == null) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        
            r3 = (T) io.reactivex.internal.functions.ObjectHelper.requireNonNull(r2.d.apply(r3.a, r3.b), "The reducer returned a null value");
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
        
            io.reactivex.exceptions.Exceptions.throwIfFatal(r3);
            innerError(r3);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void b(T r3) {
            /*
                r2 = this;
                if (r3 == 0) goto L21
            L2:
                io.reactivex.internal.operators.parallel.ParallelReduceFull$SlotPair r3 = r2.a(r3)
                if (r3 == 0) goto L21
                io.reactivex.functions.BiFunction<T, T, T> r0 = r2.d     // Catch: java.lang.Throwable -> L19
                T r1 = r3.a     // Catch: java.lang.Throwable -> L19
                T r3 = r3.b     // Catch: java.lang.Throwable -> L19
                java.lang.Object r3 = r0.apply(r1, r3)     // Catch: java.lang.Throwable -> L19
                java.lang.String r0 = "The reducer returned a null value"
                java.lang.Object r3 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r3, r0)     // Catch: java.lang.Throwable -> L19
                goto L2
            L19:
                r3 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r3)
                r2.innerError(r3)
                return
            L21:
                java.util.concurrent.atomic.AtomicInteger r3 = r2.f
                int r3 = r3.decrementAndGet()
                if (r3 != 0) goto L44
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.parallel.ParallelReduceFull$SlotPair<T>> r3 = r2.e
                java.lang.Object r3 = r3.get()
                io.reactivex.internal.operators.parallel.ParallelReduceFull$SlotPair r3 = (io.reactivex.internal.operators.parallel.ParallelReduceFull.SlotPair) r3
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.parallel.ParallelReduceFull$SlotPair<T>> r0 = r2.e
                r1 = 0
                r0.lazySet(r1)
                if (r3 == 0) goto L3f
                T r3 = r3.a
                r2.complete(r3)
                goto L44
            L3f:
                org.reactivestreams.Subscriber<? super T> r3 = r2.a
                r3.onComplete()
            L44:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelReduceFull.ParallelReduceFullMainSubscriber.b(java.lang.Object):void");
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            for (ParallelReduceFullInnerSubscriber<T> parallelReduceFullInnerSubscriber : this.c) {
                parallelReduceFullInnerSubscriber.a();
            }
        }

        void innerError(Throwable th) {
            if (this.g.compareAndSet(null, th)) {
                cancel();
                this.a.onError(th);
            } else if (th != this.g.get()) {
                RxJavaPlugins.onError(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class SlotPair<T> extends AtomicInteger {
        private static final long serialVersionUID = 473971317683868662L;
        T a;
        T b;
        final AtomicInteger c = new AtomicInteger();

        SlotPair() {
        }

        boolean a() {
            return this.c.incrementAndGet() == 2;
        }

        int b() {
            int i;
            do {
                i = get();
                if (i >= 2) {
                    return -1;
                }
            } while (!compareAndSet(i, i + 1));
            return i;
        }
    }

    public ParallelReduceFull(ParallelFlowable<? extends T> parallelFlowable, BiFunction<T, T, T> biFunction) {
        this.b = parallelFlowable;
        this.c = biFunction;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        ParallelReduceFullMainSubscriber parallelReduceFullMainSubscriber = new ParallelReduceFullMainSubscriber(subscriber, this.b.parallelism(), this.c);
        subscriber.onSubscribe(parallelReduceFullMainSubscriber);
        this.b.subscribe(parallelReduceFullMainSubscriber.c);
    }
}
