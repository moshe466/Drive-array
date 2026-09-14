package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableBufferTimed<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {
    final long b;
    final long c;
    final TimeUnit d;
    final Scheduler e;
    final Callable<U> f;
    final int g;
    final boolean h;

    /* loaded from: classes3.dex */
    static final class BufferExactBoundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {
        final Callable<U> g;
        final long h;
        final TimeUnit i;
        final int j;
        final boolean k;
        final Scheduler.Worker l;
        U m;
        Disposable n;
        Disposable o;
        long p;
        long q;

        BufferExactBoundedObserver(Observer<? super U> observer, Callable<U> callable, long j, TimeUnit timeUnit, int i, boolean z, Scheduler.Worker worker) {
            super(observer, new MpscLinkedQueue());
            this.g = callable;
            this.h = j;
            this.i = timeUnit;
            this.j = i;
            this.k = z;
            this.l = worker;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public /* bridge */ /* synthetic */ void accept(Observer observer, Object obj) {
            accept((Observer<? super Observer>) observer, (Observer) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void accept(Observer<? super U> observer, U u) {
            observer.onNext(u);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.d) {
                return;
            }
            this.d = true;
            this.o.dispose();
            this.l.dispose();
            synchronized (this) {
                this.m = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            U u;
            this.l.dispose();
            synchronized (this) {
                u = this.m;
                this.m = null;
            }
            this.c.offer(u);
            this.e = true;
            if (enter()) {
                QueueDrainHelper.drainLoop(this.c, this.b, false, this, this);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            synchronized (this) {
                this.m = null;
            }
            this.b.onError(th);
            this.l.dispose();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            synchronized (this) {
                U u = this.m;
                if (u == null) {
                    return;
                }
                u.add(t);
                if (u.size() < this.j) {
                    return;
                }
                this.m = null;
                this.p++;
                if (this.k) {
                    this.n.dispose();
                }
                b(u, false, this);
                try {
                    U u2 = (U) ObjectHelper.requireNonNull(this.g.call(), "The buffer supplied is null");
                    synchronized (this) {
                        this.m = u2;
                        this.q++;
                    }
                    if (this.k) {
                        Scheduler.Worker worker = this.l;
                        long j = this.h;
                        this.n = worker.schedulePeriodically(this, j, j, this.i);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.b.onError(th);
                    dispose();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.o, disposable)) {
                this.o = disposable;
                try {
                    this.m = (U) ObjectHelper.requireNonNull(this.g.call(), "The buffer supplied is null");
                    this.b.onSubscribe(this);
                    Scheduler.Worker worker = this.l;
                    long j = this.h;
                    this.n = worker.schedulePeriodically(this, j, j, this.i);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    disposable.dispose();
                    EmptyDisposable.error(th, this.b);
                    this.l.dispose();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u = (U) ObjectHelper.requireNonNull(this.g.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    U u2 = this.m;
                    if (u2 != null && this.p == this.q) {
                        this.m = u;
                        b(u2, false, this);
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                dispose();
                this.b.onError(th);
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class BufferExactUnboundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {
        final Callable<U> g;
        final long h;
        final TimeUnit i;
        final Scheduler j;
        Disposable k;
        U l;
        final AtomicReference<Disposable> m;

        BufferExactUnboundedObserver(Observer<? super U> observer, Callable<U> callable, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, new MpscLinkedQueue());
            this.m = new AtomicReference<>();
            this.g = callable;
            this.h = j;
            this.i = timeUnit;
            this.j = scheduler;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public /* bridge */ /* synthetic */ void accept(Observer observer, Object obj) {
            accept((Observer<? super Observer>) observer, (Observer) obj);
        }

        public void accept(Observer<? super U> observer, U u) {
            this.b.onNext(u);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.m);
            this.k.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.m.get() == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.l;
                this.l = null;
            }
            if (u != null) {
                this.c.offer(u);
                this.e = true;
                if (enter()) {
                    QueueDrainHelper.drainLoop(this.c, this.b, false, null, this);
                }
            }
            DisposableHelper.dispose(this.m);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            synchronized (this) {
                this.l = null;
            }
            this.b.onError(th);
            DisposableHelper.dispose(this.m);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            synchronized (this) {
                U u = this.l;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.k, disposable)) {
                this.k = disposable;
                try {
                    this.l = (U) ObjectHelper.requireNonNull(this.g.call(), "The buffer supplied is null");
                    this.b.onSubscribe(this);
                    if (this.d) {
                        return;
                    }
                    Scheduler scheduler = this.j;
                    long j = this.h;
                    Disposable schedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(this, j, j, this.i);
                    if (this.m.compareAndSet(null, schedulePeriodicallyDirect)) {
                        return;
                    }
                    schedulePeriodicallyDirect.dispose();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    dispose();
                    EmptyDisposable.error(th, this.b);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            U u;
            try {
                U u2 = (U) ObjectHelper.requireNonNull(this.g.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    u = this.l;
                    if (u != null) {
                        this.l = u2;
                    }
                }
                if (u == null) {
                    DisposableHelper.dispose(this.m);
                } else {
                    a(u, false, this);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.b.onError(th);
                dispose();
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class BufferSkipBoundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {
        final Callable<U> g;
        final long h;
        final long i;
        final TimeUnit j;
        final Scheduler.Worker k;
        final List<U> l;
        Disposable m;

        /* loaded from: classes3.dex */
        final class RemoveFromBuffer implements Runnable {
            private final U b;

            RemoveFromBuffer(U u) {
                this.b = u;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (BufferSkipBoundedObserver.this) {
                    BufferSkipBoundedObserver.this.l.remove(this.b);
                }
                BufferSkipBoundedObserver bufferSkipBoundedObserver = BufferSkipBoundedObserver.this;
                bufferSkipBoundedObserver.b(this.b, false, bufferSkipBoundedObserver.k);
            }
        }

        /* loaded from: classes3.dex */
        final class RemoveFromBufferEmit implements Runnable {
            private final U buffer;

            RemoveFromBufferEmit(U u) {
                this.buffer = u;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (BufferSkipBoundedObserver.this) {
                    BufferSkipBoundedObserver.this.l.remove(this.buffer);
                }
                BufferSkipBoundedObserver bufferSkipBoundedObserver = BufferSkipBoundedObserver.this;
                bufferSkipBoundedObserver.b(this.buffer, false, bufferSkipBoundedObserver.k);
            }
        }

        BufferSkipBoundedObserver(Observer<? super U> observer, Callable<U> callable, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker) {
            super(observer, new MpscLinkedQueue());
            this.g = callable;
            this.h = j;
            this.i = j2;
            this.j = timeUnit;
            this.k = worker;
            this.l = new LinkedList();
        }

        void a() {
            synchronized (this) {
                this.l.clear();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public /* bridge */ /* synthetic */ void accept(Observer observer, Object obj) {
            accept((Observer<? super Observer>) observer, (Observer) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void accept(Observer<? super U> observer, U u) {
            observer.onNext(u);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.d) {
                return;
            }
            this.d = true;
            a();
            this.m.dispose();
            this.k.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.l);
                this.l.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.c.offer((Collection) it.next());
            }
            this.e = true;
            if (enter()) {
                QueueDrainHelper.drainLoop(this.c, this.b, false, this.k, this);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.e = true;
            a();
            this.b.onError(th);
            this.k.dispose();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            synchronized (this) {
                Iterator<U> it = this.l.iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.m, disposable)) {
                this.m = disposable;
                try {
                    Collection collection = (Collection) ObjectHelper.requireNonNull(this.g.call(), "The buffer supplied is null");
                    this.l.add(collection);
                    this.b.onSubscribe(this);
                    Scheduler.Worker worker = this.k;
                    long j = this.i;
                    worker.schedulePeriodically(this, j, j, this.j);
                    this.k.schedule(new RemoveFromBufferEmit(collection), this.h, this.j);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    disposable.dispose();
                    EmptyDisposable.error(th, this.b);
                    this.k.dispose();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.d) {
                return;
            }
            try {
                Collection collection = (Collection) ObjectHelper.requireNonNull(this.g.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    if (this.d) {
                        return;
                    }
                    this.l.add(collection);
                    this.k.schedule(new RemoveFromBuffer(collection), this.h, this.j);
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.b.onError(th);
                dispose();
            }
        }
    }

    public ObservableBufferTimed(ObservableSource<T> observableSource, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable, int i, boolean z) {
        super(observableSource);
        this.b = j;
        this.c = j2;
        this.d = timeUnit;
        this.e = scheduler;
        this.f = callable;
        this.g = i;
        this.h = z;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super U> observer) {
        if (this.b == this.c && this.g == Integer.MAX_VALUE) {
            this.a.subscribe(new BufferExactUnboundedObserver(new SerializedObserver(observer), this.f, this.b, this.d, this.e));
            return;
        }
        Scheduler.Worker createWorker = this.e.createWorker();
        long j = this.b;
        long j2 = this.c;
        ObservableSource<T> observableSource = this.a;
        if (j == j2) {
            observableSource.subscribe(new BufferExactBoundedObserver(new SerializedObserver(observer), this.f, this.b, this.d, this.g, this.h, createWorker));
        } else {
            observableSource.subscribe(new BufferSkipBoundedObserver(new SerializedObserver(observer), this.f, this.b, this.c, this.d, createWorker));
        }
    }
}
