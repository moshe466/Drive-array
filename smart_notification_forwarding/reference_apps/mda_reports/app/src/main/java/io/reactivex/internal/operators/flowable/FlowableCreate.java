package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
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
public final class FlowableCreate<T> extends Flowable<T> {
    final FlowableOnSubscribe<T> b;
    final BackpressureStrategy c;

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableCreate$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[BackpressureStrategy.values().length];

        static {
            try {
                a[BackpressureStrategy.MISSING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BackpressureStrategy.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BackpressureStrategy.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BackpressureStrategy.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class BaseEmitter<T> extends AtomicLong implements FlowableEmitter<T>, Subscription {
        private static final long serialVersionUID = 7326289992464377023L;
        final Subscriber<? super T> a;
        final SequentialDisposable b = new SequentialDisposable();

        BaseEmitter(Subscriber<? super T> subscriber) {
            this.a = subscriber;
        }

        protected void a() {
            if (isCancelled()) {
                return;
            }
            try {
                this.a.onComplete();
            } finally {
                this.b.dispose();
            }
        }

        protected boolean a(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isCancelled()) {
                return false;
            }
            try {
                this.a.onError(th);
                this.b.dispose();
                return true;
            } catch (Throwable th2) {
                this.b.dispose();
                throw th2;
            }
        }

        void b() {
        }

        void c() {
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.b.dispose();
            c();
        }

        @Override // io.reactivex.FlowableEmitter
        public final boolean isCancelled() {
            return this.b.isDisposed();
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            a();
        }

        @Override // io.reactivex.Emitter
        public final void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this, j);
                b();
            }
        }

        @Override // io.reactivex.FlowableEmitter
        public final long requested() {
            return get();
        }

        @Override // io.reactivex.FlowableEmitter
        public final FlowableEmitter<T> serialize() {
            return new SerializedEmitter(this);
        }

        @Override // io.reactivex.FlowableEmitter
        public final void setCancellable(Cancellable cancellable) {
            setDisposable(new CancellableDisposable(cancellable));
        }

        @Override // io.reactivex.FlowableEmitter
        public final void setDisposable(Disposable disposable) {
            this.b.update(disposable);
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public String toString() {
            return String.format("%s{%s}", getClass().getSimpleName(), super.toString());
        }

        @Override // io.reactivex.FlowableEmitter
        public boolean tryOnError(Throwable th) {
            return a(th);
        }
    }

    /* loaded from: classes2.dex */
    static final class BufferAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        final SpscLinkedArrayQueue<T> c;
        Throwable d;
        volatile boolean e;
        final AtomicInteger f;

        BufferAsyncEmitter(Subscriber<? super T> subscriber, int i) {
            super(subscriber);
            this.c = new SpscLinkedArrayQueue<>(i);
            this.f = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void b() {
            d();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void c() {
            if (this.f.getAndIncrement() == 0) {
                this.c.clear();
            }
        }

        void d() {
            if (this.f.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.a;
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.c;
            int i = 1;
            do {
                long j = get();
                long j2 = 0;
                while (j2 != j) {
                    if (isCancelled()) {
                        spscLinkedArrayQueue.clear();
                        return;
                    }
                    boolean z = this.e;
                    T poll = spscLinkedArrayQueue.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        Throwable th = this.d;
                        if (th != null) {
                            a(th);
                            return;
                        } else {
                            a();
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.onNext(poll);
                    j2++;
                }
                if (j2 == j) {
                    if (isCancelled()) {
                        spscLinkedArrayQueue.clear();
                        return;
                    }
                    boolean z3 = this.e;
                    boolean isEmpty = spscLinkedArrayQueue.isEmpty();
                    if (z3 && isEmpty) {
                        Throwable th2 = this.d;
                        if (th2 != null) {
                            a(th2);
                            return;
                        } else {
                            a();
                            return;
                        }
                    }
                }
                if (j2 != 0) {
                    BackpressureHelper.produced(this, j2);
                }
                i = this.f.addAndGet(-i);
            } while (i != 0);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.Emitter
        public void onComplete() {
            this.e = true;
            d();
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t) {
            if (this.e || isCancelled()) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.c.offer(t);
                d();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.FlowableEmitter
        public boolean tryOnError(Throwable th) {
            if (this.e || isCancelled()) {
                return false;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.d = th;
            this.e = true;
            d();
            return true;
        }
    }

    /* loaded from: classes2.dex */
    static final class DropAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        DropAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.NoOverflowBaseAsyncEmitter
        void d() {
        }
    }

    /* loaded from: classes2.dex */
    static final class ErrorAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 338953216916120960L;

        ErrorAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.NoOverflowBaseAsyncEmitter
        void d() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }

    /* loaded from: classes2.dex */
    static final class LatestAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        final AtomicReference<T> c;
        Throwable d;
        volatile boolean e;
        final AtomicInteger f;

        LatestAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
            this.c = new AtomicReference<>();
            this.f = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void b() {
            d();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void c() {
            if (this.f.getAndIncrement() == 0) {
                this.c.lazySet(null);
            }
        }

        void d() {
            if (this.f.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.a;
            AtomicReference<T> atomicReference = this.c;
            int i = 1;
            do {
                long j = get();
                long j2 = 0;
                while (true) {
                    if (j2 == j) {
                        break;
                    }
                    if (isCancelled()) {
                        atomicReference.lazySet(null);
                        return;
                    }
                    boolean z = this.e;
                    T andSet = atomicReference.getAndSet(null);
                    boolean z2 = andSet == null;
                    if (z && z2) {
                        Throwable th = this.d;
                        if (th != null) {
                            a(th);
                            return;
                        } else {
                            a();
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.onNext(andSet);
                    j2++;
                }
                if (j2 == j) {
                    if (isCancelled()) {
                        atomicReference.lazySet(null);
                        return;
                    }
                    boolean z3 = this.e;
                    boolean z4 = atomicReference.get() == null;
                    if (z3 && z4) {
                        Throwable th2 = this.d;
                        if (th2 != null) {
                            a(th2);
                            return;
                        } else {
                            a();
                            return;
                        }
                    }
                }
                if (j2 != 0) {
                    BackpressureHelper.produced(this, j2);
                }
                i = this.f.addAndGet(-i);
            } while (i != 0);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.Emitter
        public void onComplete() {
            this.e = true;
            d();
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t) {
            if (this.e || isCancelled()) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.c.set(t);
                d();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.FlowableEmitter
        public boolean tryOnError(Throwable th) {
            if (this.e || isCancelled()) {
                return false;
            }
            if (th == null) {
                onError(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
            this.d = th;
            this.e = true;
            d();
            return true;
        }
    }

    /* loaded from: classes2.dex */
    static final class MissingEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        MissingEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t) {
            long j;
            if (isCancelled()) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            this.a.onNext(t);
            do {
                j = get();
                if (j == 0) {
                    return;
                }
            } while (!compareAndSet(j, j - 1));
        }
    }

    /* loaded from: classes2.dex */
    static abstract class NoOverflowBaseAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        NoOverflowBaseAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        abstract void d();

        @Override // io.reactivex.Emitter
        public final void onNext(T t) {
            if (isCancelled()) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (get() == 0) {
                d();
            } else {
                this.a.onNext(t);
                BackpressureHelper.produced(this, 1L);
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class SerializedEmitter<T> extends AtomicInteger implements FlowableEmitter<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        final BaseEmitter<T> a;
        final AtomicThrowable b = new AtomicThrowable();
        final SimplePlainQueue<T> c = new SpscLinkedArrayQueue(16);
        volatile boolean d;

        SerializedEmitter(BaseEmitter<T> baseEmitter) {
            this.a = baseEmitter;
        }

        void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        void b() {
            BaseEmitter<T> baseEmitter = this.a;
            SimplePlainQueue<T> simplePlainQueue = this.c;
            AtomicThrowable atomicThrowable = this.b;
            int i = 1;
            while (!baseEmitter.isCancelled()) {
                if (atomicThrowable.get() != null) {
                    simplePlainQueue.clear();
                    baseEmitter.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z = this.d;
                T poll = simplePlainQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    baseEmitter.onComplete();
                    return;
                } else if (z2) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    baseEmitter.onNext(poll);
                }
            }
            simplePlainQueue.clear();
        }

        @Override // io.reactivex.FlowableEmitter
        public boolean isCancelled() {
            return this.a.isCancelled();
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            if (this.a.isCancelled() || this.d) {
                return;
            }
            this.d = true;
            a();
        }

        @Override // io.reactivex.Emitter
        public void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t) {
            if (this.a.isCancelled() || this.d) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            if (get() == 0 && compareAndSet(0, 1)) {
                this.a.onNext(t);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimplePlainQueue<T> simplePlainQueue = this.c;
                synchronized (simplePlainQueue) {
                    simplePlainQueue.offer(t);
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        @Override // io.reactivex.FlowableEmitter
        public long requested() {
            return this.a.requested();
        }

        @Override // io.reactivex.FlowableEmitter
        public FlowableEmitter<T> serialize() {
            return this;
        }

        @Override // io.reactivex.FlowableEmitter
        public void setCancellable(Cancellable cancellable) {
            this.a.setCancellable(cancellable);
        }

        @Override // io.reactivex.FlowableEmitter
        public void setDisposable(Disposable disposable) {
            this.a.setDisposable(disposable);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public String toString() {
            return this.a.toString();
        }

        @Override // io.reactivex.FlowableEmitter
        public boolean tryOnError(Throwable th) {
            if (!this.a.isCancelled() && !this.d) {
                if (th == null) {
                    th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                }
                if (this.b.addThrowable(th)) {
                    this.d = true;
                    a();
                    return true;
                }
            }
            return false;
        }
    }

    public FlowableCreate(FlowableOnSubscribe<T> flowableOnSubscribe, BackpressureStrategy backpressureStrategy) {
        this.b = flowableOnSubscribe;
        this.c = backpressureStrategy;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        int i = AnonymousClass1.a[this.c.ordinal()];
        BaseEmitter bufferAsyncEmitter = i != 1 ? i != 2 ? i != 3 ? i != 4 ? new BufferAsyncEmitter(subscriber, Flowable.bufferSize()) : new LatestAsyncEmitter(subscriber) : new DropAsyncEmitter(subscriber) : new ErrorAsyncEmitter(subscriber) : new MissingEmitter(subscriber);
        subscriber.onSubscribe(bufferAsyncEmitter);
        try {
            this.b.subscribe(bufferAsyncEmitter);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            bufferAsyncEmitter.onError(th);
        }
    }
}
