package io.reactivex.internal.operators.mixed;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Experimental
/* loaded from: classes2.dex */
public final class FlowableConcatMapMaybe<T, R> extends Flowable<R> {
    final Flowable<T> b;
    final Function<? super T, ? extends MaybeSource<? extends R>> c;
    final ErrorMode d;
    final int e;

    /* loaded from: classes2.dex */
    static final class ConcatMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -9140123220065488293L;
        final Subscriber<? super R> a;
        final Function<? super T, ? extends MaybeSource<? extends R>> b;
        final int c;
        final AtomicLong d = new AtomicLong();
        final AtomicThrowable e = new AtomicThrowable();
        final ConcatMapMaybeObserver<R> f = new ConcatMapMaybeObserver<>(this);
        final SimplePlainQueue<T> g;
        final ErrorMode h;
        Subscription i;
        volatile boolean j;
        volatile boolean k;
        long l;
        int m;
        R n;
        volatile int o;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public static final class ConcatMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long serialVersionUID = -3051469169682093892L;
            final ConcatMapMaybeSubscriber<?, R> a;

            ConcatMapMaybeObserver(ConcatMapMaybeSubscriber<?, R> concatMapMaybeSubscriber) {
                this.a = concatMapMaybeSubscriber;
            }

            void a() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.a.b();
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                this.a.a(th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(R r) {
                this.a.a((ConcatMapMaybeSubscriber<?, R>) r);
            }
        }

        ConcatMapMaybeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends MaybeSource<? extends R>> function, int i, ErrorMode errorMode) {
            this.a = subscriber;
            this.b = function;
            this.c = i;
            this.h = errorMode;
            this.g = new SpscArrayQueue(i);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
        
            r2.clear();
            r15.n = null;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void a() {
            /*
                r15 = this;
                int r0 = r15.getAndIncrement()
                if (r0 == 0) goto L7
                return
            L7:
                org.reactivestreams.Subscriber<? super R> r0 = r15.a
                io.reactivex.internal.util.ErrorMode r1 = r15.h
                io.reactivex.internal.fuseable.SimplePlainQueue<T> r2 = r15.g
                io.reactivex.internal.util.AtomicThrowable r3 = r15.e
                java.util.concurrent.atomic.AtomicLong r4 = r15.d
                int r5 = r15.c
                int r6 = r5 >> 1
                int r5 = r5 - r6
                r6 = 1
                r7 = 1
            L18:
                boolean r8 = r15.k
                r9 = 0
                if (r8 == 0) goto L22
                r2.clear()
                r15.n = r9
            L22:
                int r8 = r15.o
                java.lang.Object r10 = r3.get()
                if (r10 == 0) goto L41
                io.reactivex.internal.util.ErrorMode r10 = io.reactivex.internal.util.ErrorMode.IMMEDIATE
                if (r1 == r10) goto L34
                io.reactivex.internal.util.ErrorMode r10 = io.reactivex.internal.util.ErrorMode.BOUNDARY
                if (r1 != r10) goto L41
                if (r8 != 0) goto L41
            L34:
                r2.clear()
                r15.n = r9
            L39:
                java.lang.Throwable r1 = r3.terminate()
                r0.onError(r1)
                return
            L41:
                r10 = 0
                if (r8 != 0) goto L9a
                boolean r8 = r15.j
                java.lang.Object r9 = r2.poll()
                if (r9 != 0) goto L4e
                r11 = 1
                goto L4f
            L4e:
                r11 = 0
            L4f:
                if (r8 == 0) goto L61
                if (r11 == 0) goto L61
                java.lang.Throwable r1 = r3.terminate()
                if (r1 != 0) goto L5d
                r0.onComplete()
                goto L60
            L5d:
                r0.onError(r1)
            L60:
                return
            L61:
                if (r11 == 0) goto L64
                goto Lb7
            L64:
                int r8 = r15.m
                int r8 = r8 + r6
                if (r8 != r5) goto L72
                r15.m = r10
                org.reactivestreams.Subscription r8 = r15.i
                long r10 = (long) r5
                r8.request(r10)
                goto L74
            L72:
                r15.m = r8
            L74:
                io.reactivex.functions.Function<? super T, ? extends io.reactivex.MaybeSource<? extends R>> r8 = r15.b     // Catch: java.lang.Throwable -> L8a
                java.lang.Object r8 = r8.apply(r9)     // Catch: java.lang.Throwable -> L8a
                java.lang.String r9 = "The mapper returned a null MaybeSource"
                java.lang.Object r8 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r8, r9)     // Catch: java.lang.Throwable -> L8a
                io.reactivex.MaybeSource r8 = (io.reactivex.MaybeSource) r8     // Catch: java.lang.Throwable -> L8a
                r15.o = r6
                io.reactivex.internal.operators.mixed.FlowableConcatMapMaybe$ConcatMapMaybeSubscriber$ConcatMapMaybeObserver<R> r9 = r15.f
                r8.subscribe(r9)
                goto Lb7
            L8a:
                r1 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r1)
                org.reactivestreams.Subscription r4 = r15.i
                r4.cancel()
                r2.clear()
                r3.addThrowable(r1)
                goto L39
            L9a:
                r11 = 2
                if (r8 != r11) goto Lb7
                long r11 = r15.l
                long r13 = r4.get()
                int r8 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                if (r8 == 0) goto Lb7
                R r8 = r15.n
                r15.n = r9
                r0.onNext(r8)
                r8 = 1
                long r11 = r11 + r8
                r15.l = r11
                r15.o = r10
                goto L18
            Lb7:
                int r7 = -r7
                int r7 = r15.addAndGet(r7)
                if (r7 != 0) goto L18
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.mixed.FlowableConcatMapMaybe.ConcatMapMaybeSubscriber.a():void");
        }

        void a(R r) {
            this.n = r;
            this.o = 2;
            a();
        }

        void a(Throwable th) {
            if (!this.e.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (this.h != ErrorMode.END) {
                this.i.cancel();
            }
            this.o = 0;
            a();
        }

        void b() {
            this.o = 0;
            a();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.k = true;
            this.i.cancel();
            this.f.a();
            if (getAndIncrement() == 0) {
                this.g.clear();
                this.n = null;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.j = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.e.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (this.h == ErrorMode.IMMEDIATE) {
                this.f.a();
            }
            this.j = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.g.offer(t)) {
                a();
            } else {
                this.i.cancel();
                onError(new MissingBackpressureException("queue full?!"));
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.i, subscription)) {
                this.i = subscription;
                this.a.onSubscribe(this);
                subscription.request(this.c);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            BackpressureHelper.add(this.d, j);
            a();
        }
    }

    public FlowableConcatMapMaybe(Flowable<T> flowable, Function<? super T, ? extends MaybeSource<? extends R>> function, ErrorMode errorMode, int i) {
        this.b = flowable;
        this.c = function;
        this.d = errorMode;
        this.e = i;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe((FlowableSubscriber) new ConcatMapMaybeSubscriber(subscriber, this.c, this.e, this.d));
    }
}
