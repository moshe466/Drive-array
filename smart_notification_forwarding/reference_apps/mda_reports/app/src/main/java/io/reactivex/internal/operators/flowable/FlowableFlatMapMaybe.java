package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableFlatMapMaybe<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super T, ? extends MaybeSource<? extends R>> c;
    final boolean d;
    final int e;

    /* loaded from: classes2.dex */
    static final class FlatMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 8600231336733376951L;
        final Subscriber<? super R> a;
        final boolean b;
        final int c;
        final Function<? super T, ? extends MaybeSource<? extends R>> h;
        Subscription j;
        volatile boolean k;
        final AtomicLong d = new AtomicLong();
        final CompositeDisposable e = new CompositeDisposable();
        final AtomicThrowable g = new AtomicThrowable();
        final AtomicInteger f = new AtomicInteger(1);
        final AtomicReference<SpscLinkedArrayQueue<R>> i = new AtomicReference<>();

        /* loaded from: classes2.dex */
        final class InnerObserver extends AtomicReference<Disposable> implements MaybeObserver<R>, Disposable {
            private static final long serialVersionUID = -502562646270949838L;

            InnerObserver() {
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                FlatMapMaybeSubscriber.this.a(this);
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                FlatMapMaybeSubscriber.this.a(this, th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(R r) {
                FlatMapMaybeSubscriber.this.a((FlatMapMaybeSubscriber<T, InnerObserver>.InnerObserver) this, (InnerObserver) r);
            }
        }

        FlatMapMaybeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z, int i) {
            this.a = subscriber;
            this.h = function;
            this.b = z;
            this.c = i;
        }

        void a() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.i.get();
            if (spscLinkedArrayQueue != null) {
                spscLinkedArrayQueue.clear();
            }
        }

        void a(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver) {
            this.e.delete(innerObserver);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    boolean z = this.f.decrementAndGet() == 0;
                    SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.i.get();
                    if (z && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                        Throwable terminate = this.g.terminate();
                        if (terminate != null) {
                            this.a.onError(terminate);
                            return;
                        } else {
                            this.a.onComplete();
                            return;
                        }
                    }
                    if (this.c != Integer.MAX_VALUE) {
                        this.j.request(1L);
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    c();
                    return;
                }
            }
            this.f.decrementAndGet();
            if (this.c != Integer.MAX_VALUE) {
                this.j.request(1L);
            }
            b();
        }

        void a(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, R r) {
            this.e.delete(innerObserver);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    boolean z = this.f.decrementAndGet() == 0;
                    if (this.d.get() != 0) {
                        this.a.onNext(r);
                        SpscLinkedArrayQueue<R> spscLinkedArrayQueue = this.i.get();
                        if (z && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                            Throwable terminate = this.g.terminate();
                            if (terminate != null) {
                                this.a.onError(terminate);
                                return;
                            } else {
                                this.a.onComplete();
                                return;
                            }
                        }
                        BackpressureHelper.produced(this.d, 1L);
                        if (this.c != Integer.MAX_VALUE) {
                            this.j.request(1L);
                        }
                    } else {
                        SpscLinkedArrayQueue<R> d = d();
                        synchronized (d) {
                            d.offer(r);
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    c();
                }
            }
            SpscLinkedArrayQueue<R> d2 = d();
            synchronized (d2) {
                d2.offer(r);
            }
            this.f.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            c();
        }

        void a(FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, Throwable th) {
            this.e.delete(innerObserver);
            if (!this.g.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (!this.b) {
                this.j.cancel();
                this.e.dispose();
            } else if (this.c != Integer.MAX_VALUE) {
                this.j.request(1L);
            }
            this.f.decrementAndGet();
            b();
        }

        void b() {
            if (getAndIncrement() == 0) {
                c();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
        
            r1 = r15.g.terminate();
            a();
            r0.onError(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0075, code lost:
        
            if (r9 != r5) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0079, code lost:
        
            if (r15.k == false) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0081, code lost:
        
            if (r15.b != false) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x008b, code lost:
        
            if (r15.g.get() == null) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0092, code lost:
        
            if (r1.get() != 0) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0094, code lost:
        
            r5 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0097, code lost:
        
            r6 = r2.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x009d, code lost:
        
            if (r6 == null) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00a3, code lost:
        
            if (r6.isEmpty() == false) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00a6, code lost:
        
            if (r5 == false) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00a8, code lost:
        
            if (r11 == false) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00aa, code lost:
        
            r1 = r15.g.terminate();
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00b0, code lost:
        
            if (r1 == null) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00b2, code lost:
        
            r0.onError(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00b6, code lost:
        
            r0.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00b9, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00a5, code lost:
        
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x0096, code lost:
        
            r5 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x007b, code lost:
        
            a();
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x007e, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00bc, code lost:
        
            if (r9 == 0) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00be, code lost:
        
            io.reactivex.internal.util.BackpressureHelper.produced(r15.d, r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00c8, code lost:
        
            if (r15.c == Integer.MAX_VALUE) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00ca, code lost:
        
            r15.j.request(r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x00cf, code lost:
        
            r4 = addAndGet(-r4);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void c() {
            /*
                Method dump skipped, instructions count: 215
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe.FlatMapMaybeSubscriber.c():void");
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.k = true;
            this.j.cancel();
            this.e.dispose();
        }

        SpscLinkedArrayQueue<R> d() {
            SpscLinkedArrayQueue<R> spscLinkedArrayQueue;
            do {
                SpscLinkedArrayQueue<R> spscLinkedArrayQueue2 = this.i.get();
                if (spscLinkedArrayQueue2 != null) {
                    return spscLinkedArrayQueue2;
                }
                spscLinkedArrayQueue = new SpscLinkedArrayQueue<>(Flowable.bufferSize());
            } while (!this.i.compareAndSet(null, spscLinkedArrayQueue));
            return spscLinkedArrayQueue;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f.decrementAndGet();
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f.decrementAndGet();
            if (!this.g.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (!this.b) {
                this.e.dispose();
            }
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.requireNonNull(this.h.apply(t), "The mapper returned a null MaybeSource");
                this.f.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (this.k || !this.e.add(innerObserver)) {
                    return;
                }
                maybeSource.subscribe(innerObserver);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.j.cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.j, subscription)) {
                this.j = subscription;
                this.a.onSubscribe(this);
                int i = this.c;
                subscription.request(i == Integer.MAX_VALUE ? Long.MAX_VALUE : i);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.d, j);
                b();
            }
        }
    }

    public FlowableFlatMapMaybe(Flowable<T> flowable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z, int i) {
        super(flowable);
        this.c = function;
        this.d = z;
        this.e = i;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> subscriber) {
        this.b.subscribe((FlowableSubscriber) new FlatMapMaybeSubscriber(subscriber, this.c, this.d, this.e));
    }
}
