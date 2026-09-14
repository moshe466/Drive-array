package io.reactivex.internal.operators.flowable;

import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableGenerate<T, S> extends Flowable<T> {
    final Callable<S> b;
    final BiFunction<S, Emitter<T>, S> c;
    final Consumer<? super S> d;

    /* loaded from: classes2.dex */
    static final class GeneratorSubscription<T, S> extends AtomicLong implements Emitter<T>, Subscription {
        private static final long serialVersionUID = 7565982551505011832L;
        final Subscriber<? super T> a;
        final BiFunction<S, ? super Emitter<T>, S> b;
        final Consumer<? super S> c;
        S d;
        volatile boolean e;
        boolean f;
        boolean g;

        GeneratorSubscription(Subscriber<? super T> subscriber, BiFunction<S, ? super Emitter<T>, S> biFunction, Consumer<? super S> consumer, S s) {
            this.a = subscriber;
            this.b = biFunction;
            this.c = consumer;
            this.d = s;
        }

        private void dispose(S s) {
            try {
                this.c.accept(s);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.e) {
                return;
            }
            this.e = true;
            if (BackpressureHelper.add(this, 1L) == 0) {
                S s = this.d;
                this.d = null;
                dispose(s);
            }
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            if (this.f) {
                return;
            }
            this.f = true;
            this.a.onComplete();
        }

        @Override // io.reactivex.Emitter
        public void onError(Throwable th) {
            if (this.f) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f = true;
            this.a.onError(th);
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t) {
            Throwable nullPointerException;
            if (this.f) {
                return;
            }
            if (this.g) {
                nullPointerException = new IllegalStateException("onNext already called in this generate turn");
            } else {
                if (t != null) {
                    this.g = true;
                    this.a.onNext(t);
                    return;
                }
                nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            onError(nullPointerException);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x004e, code lost:
        
            r9.d = r0;
            r4 = addAndGet(-r10);
         */
        @Override // org.reactivestreams.Subscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void request(long r10) {
            /*
                r9 = this;
                boolean r0 = io.reactivex.internal.subscriptions.SubscriptionHelper.validate(r10)
                if (r0 != 0) goto L7
                return
            L7:
                long r0 = io.reactivex.internal.util.BackpressureHelper.add(r9, r10)
                r2 = 0
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 == 0) goto L12
                return
            L12:
                S r0 = r9.d
                io.reactivex.functions.BiFunction<S, ? super io.reactivex.Emitter<T>, S> r1 = r9.b
                r4 = r10
            L17:
                r10 = r2
            L18:
                int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
                if (r6 == 0) goto L46
                boolean r6 = r9.e
                r7 = 0
                if (r6 == 0) goto L27
            L21:
                r9.d = r7
            L23:
                r9.dispose(r0)
                return
            L27:
                r6 = 0
                r9.g = r6
                r6 = 1
                java.lang.Object r0 = r1.apply(r0, r9)     // Catch: java.lang.Throwable -> L3a
                boolean r8 = r9.f
                if (r8 == 0) goto L36
                r9.e = r6
                goto L21
            L36:
                r6 = 1
                long r10 = r10 + r6
                goto L18
            L3a:
                r10 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r10)
                r9.e = r6
                r9.d = r7
                r9.onError(r10)
                goto L23
            L46:
                long r4 = r9.get()
                int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
                if (r6 != 0) goto L18
                r9.d = r0
                long r10 = -r10
                long r4 = r9.addAndGet(r10)
                int r10 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r10 != 0) goto L17
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableGenerate.GeneratorSubscription.request(long):void");
        }
    }

    public FlowableGenerate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        this.b = callable;
        this.c = biFunction;
        this.d = consumer;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            subscriber.onSubscribe(new GeneratorSubscription(subscriber, this.c, this.d, this.b.call()));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptySubscription.error(th, subscriber);
        }
    }
}
