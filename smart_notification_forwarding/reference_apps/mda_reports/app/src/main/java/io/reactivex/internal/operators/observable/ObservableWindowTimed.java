package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.subjects.UnicastSubject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableWindowTimed<T> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final long b;
    final long c;
    final TimeUnit d;
    final Scheduler e;
    final long f;
    final int g;
    final boolean h;

    /* loaded from: classes3.dex */
    static final class WindowExactBoundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {
        final long g;
        final TimeUnit h;
        final Scheduler i;
        final int j;
        final boolean k;
        final long l;
        final Scheduler.Worker m;
        long n;
        long o;
        Disposable p;
        UnicastSubject<T> q;
        volatile boolean r;
        final AtomicReference<Disposable> s;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static final class ConsumerIndexHolder implements Runnable {
            final long a;
            final WindowExactBoundedObserver<?> b;

            ConsumerIndexHolder(long j, WindowExactBoundedObserver<?> windowExactBoundedObserver) {
                this.a = j;
                this.b = windowExactBoundedObserver;
            }

            @Override // java.lang.Runnable
            public void run() {
                WindowExactBoundedObserver<?> windowExactBoundedObserver = this.b;
                if (((QueueDrainObserver) windowExactBoundedObserver).d) {
                    windowExactBoundedObserver.r = true;
                    windowExactBoundedObserver.a();
                } else {
                    ((QueueDrainObserver) windowExactBoundedObserver).c.offer(this);
                }
                if (windowExactBoundedObserver.enter()) {
                    windowExactBoundedObserver.b();
                }
            }
        }

        WindowExactBoundedObserver(Observer<? super Observable<T>> observer, long j, TimeUnit timeUnit, Scheduler scheduler, int i, long j2, boolean z) {
            super(observer, new MpscLinkedQueue());
            this.s = new AtomicReference<>();
            this.g = j;
            this.h = timeUnit;
            this.i = scheduler;
            this.j = i;
            this.l = j2;
            this.k = z;
            this.m = z ? scheduler.createWorker() : null;
        }

        void a() {
            DisposableHelper.dispose(this.s);
            Scheduler.Worker worker = this.m;
            if (worker != null) {
                worker.dispose();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [io.reactivex.Observer<? super V>, io.reactivex.Observer] */
        /* JADX WARN: Type inference failed for: r4v8, types: [io.reactivex.subjects.UnicastSubject] */
        void b() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.c;
            ?? r1 = this.b;
            UnicastSubject unicastSubject = this.q;
            int i = 1;
            while (!this.r) {
                boolean z = this.e;
                Object poll = mpscLinkedQueue.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof ConsumerIndexHolder;
                if (z && (z2 || z3)) {
                    this.q = null;
                    mpscLinkedQueue.clear();
                    a();
                    Throwable th = this.f;
                    if (th != null) {
                        unicastSubject.onError(th);
                        return;
                    } else {
                        unicastSubject.onComplete();
                        return;
                    }
                }
                if (z2) {
                    i = leave(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (z3) {
                    ConsumerIndexHolder consumerIndexHolder = (ConsumerIndexHolder) poll;
                    if (this.k || this.o == consumerIndexHolder.a) {
                        unicastSubject.onComplete();
                        this.n = 0L;
                        unicastSubject = (UnicastSubject<T>) UnicastSubject.create(this.j);
                        this.q = unicastSubject;
                        r1.onNext(unicastSubject);
                    }
                } else {
                    unicastSubject.onNext(NotificationLite.getValue(poll));
                    long j = this.n + 1;
                    if (j >= this.l) {
                        this.o++;
                        this.n = 0L;
                        unicastSubject.onComplete();
                        unicastSubject = (UnicastSubject<T>) UnicastSubject.create(this.j);
                        this.q = unicastSubject;
                        this.b.onNext(unicastSubject);
                        if (this.k) {
                            Disposable disposable = this.s.get();
                            disposable.dispose();
                            Scheduler.Worker worker = this.m;
                            ConsumerIndexHolder consumerIndexHolder2 = new ConsumerIndexHolder(this.o, this);
                            long j2 = this.g;
                            Disposable schedulePeriodically = worker.schedulePeriodically(consumerIndexHolder2, j2, j2, this.h);
                            if (!this.s.compareAndSet(disposable, schedulePeriodically)) {
                                schedulePeriodically.dispose();
                            }
                        }
                    } else {
                        this.n = j;
                    }
                }
            }
            this.p.dispose();
            mpscLinkedQueue.clear();
            a();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.d = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.e = true;
            if (enter()) {
                b();
            }
            this.b.onComplete();
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f = th;
            this.e = true;
            if (enter()) {
                b();
            }
            this.b.onError(th);
            a();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.r) {
                return;
            }
            if (fastEnter()) {
                UnicastSubject<T> unicastSubject = this.q;
                unicastSubject.onNext(t);
                long j = this.n + 1;
                if (j >= this.l) {
                    this.o++;
                    this.n = 0L;
                    unicastSubject.onComplete();
                    UnicastSubject<T> create = UnicastSubject.create(this.j);
                    this.q = create;
                    this.b.onNext(create);
                    if (this.k) {
                        this.s.get().dispose();
                        Scheduler.Worker worker = this.m;
                        ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.o, this);
                        long j2 = this.g;
                        DisposableHelper.replace(this.s, worker.schedulePeriodically(consumerIndexHolder, j2, j2, this.h));
                    }
                } else {
                    this.n = j;
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.c.offer(NotificationLite.next(t));
                if (!enter()) {
                    return;
                }
            }
            b();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Disposable schedulePeriodicallyDirect;
            if (DisposableHelper.validate(this.p, disposable)) {
                this.p = disposable;
                Observer<? super V> observer = this.b;
                observer.onSubscribe(this);
                if (this.d) {
                    return;
                }
                UnicastSubject<T> create = UnicastSubject.create(this.j);
                this.q = create;
                observer.onNext(create);
                ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.o, this);
                if (this.k) {
                    Scheduler.Worker worker = this.m;
                    long j = this.g;
                    schedulePeriodicallyDirect = worker.schedulePeriodically(consumerIndexHolder, j, j, this.h);
                } else {
                    Scheduler scheduler = this.i;
                    long j2 = this.g;
                    schedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(consumerIndexHolder, j2, j2, this.h);
                }
                DisposableHelper.replace(this.s, schedulePeriodicallyDirect);
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class WindowExactUnboundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Observer<T>, Disposable, Runnable {
        static final Object o = new Object();
        final long g;
        final TimeUnit h;
        final Scheduler i;
        final int j;
        Disposable k;
        UnicastSubject<T> l;
        final AtomicReference<Disposable> m;
        volatile boolean n;

        WindowExactUnboundedObserver(Observer<? super Observable<T>> observer, long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
            super(observer, new MpscLinkedQueue());
            this.m = new AtomicReference<>();
            this.g = j;
            this.h = timeUnit;
            this.i = scheduler;
            this.j = i;
        }

        void a() {
            DisposableHelper.dispose(this.m);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
        
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        
            r7.l = null;
            r0.clear();
            a();
            r0 = r7.f;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
        
            if (r0 == null) goto L11;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [io.reactivex.subjects.UnicastSubject<T>] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void b() {
            /*
                r7 = this;
                io.reactivex.internal.fuseable.SimplePlainQueue<U> r0 = r7.c
                io.reactivex.internal.queue.MpscLinkedQueue r0 = (io.reactivex.internal.queue.MpscLinkedQueue) r0
                io.reactivex.Observer<? super V> r1 = r7.b
                io.reactivex.subjects.UnicastSubject<T> r2 = r7.l
                r3 = 1
            L9:
                boolean r4 = r7.n
                boolean r5 = r7.e
                java.lang.Object r6 = r0.poll()
                if (r5 == 0) goto L2e
                if (r6 == 0) goto L19
                java.lang.Object r5 = io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactUnboundedObserver.o
                if (r6 != r5) goto L2e
            L19:
                r1 = 0
                r7.l = r1
                r0.clear()
                r7.a()
                java.lang.Throwable r0 = r7.f
                if (r0 == 0) goto L2a
                r2.onError(r0)
                goto L2d
            L2a:
                r2.onComplete()
            L2d:
                return
            L2e:
                if (r6 != 0) goto L38
                int r3 = -r3
                int r3 = r7.leave(r3)
                if (r3 != 0) goto L9
                return
            L38:
                java.lang.Object r5 = io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactUnboundedObserver.o
                if (r6 != r5) goto L53
                r2.onComplete()
                if (r4 != 0) goto L4d
                int r2 = r7.j
                io.reactivex.subjects.UnicastSubject r2 = io.reactivex.subjects.UnicastSubject.create(r2)
                r7.l = r2
                r1.onNext(r2)
                goto L9
            L4d:
                io.reactivex.disposables.Disposable r4 = r7.k
                r4.dispose()
                goto L9
            L53:
                java.lang.Object r4 = io.reactivex.internal.util.NotificationLite.getValue(r6)
                r2.onNext(r4)
                goto L9
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactUnboundedObserver.b():void");
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.d = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.e = true;
            if (enter()) {
                b();
            }
            a();
            this.b.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f = th;
            this.e = true;
            if (enter()) {
                b();
            }
            a();
            this.b.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.n) {
                return;
            }
            if (fastEnter()) {
                this.l.onNext(t);
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.c.offer(NotificationLite.next(t));
                if (!enter()) {
                    return;
                }
            }
            b();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.k, disposable)) {
                this.k = disposable;
                this.l = UnicastSubject.create(this.j);
                Observer<? super V> observer = this.b;
                observer.onSubscribe(this);
                observer.onNext(this.l);
                if (this.d) {
                    return;
                }
                Scheduler scheduler = this.i;
                long j = this.g;
                DisposableHelper.replace(this.m, scheduler.schedulePeriodicallyDirect(this, j, j, this.h));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.d) {
                this.n = true;
                a();
            }
            this.c.offer(o);
            if (enter()) {
                b();
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class WindowSkipObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable, Runnable {
        final long g;
        final long h;
        final TimeUnit i;
        final Scheduler.Worker j;
        final int k;
        final List<UnicastSubject<T>> l;
        Disposable m;
        volatile boolean n;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public final class CompletionTask implements Runnable {
            private final UnicastSubject<T> w;

            CompletionTask(UnicastSubject<T> unicastSubject) {
                this.w = unicastSubject;
            }

            @Override // java.lang.Runnable
            public void run() {
                WindowSkipObserver.this.a(this.w);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static final class SubjectWork<T> {
            final UnicastSubject<T> a;
            final boolean b;

            SubjectWork(UnicastSubject<T> unicastSubject, boolean z) {
                this.a = unicastSubject;
                this.b = z;
            }
        }

        WindowSkipObserver(Observer<? super Observable<T>> observer, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker, int i) {
            super(observer, new MpscLinkedQueue());
            this.g = j;
            this.h = j2;
            this.i = timeUnit;
            this.j = worker;
            this.k = i;
            this.l = new LinkedList();
        }

        void a() {
            this.j.dispose();
        }

        void a(UnicastSubject<T> unicastSubject) {
            this.c.offer(new SubjectWork(unicastSubject, false));
            if (enter()) {
                b();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void b() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.c;
            Observer<? super V> observer = this.b;
            List<UnicastSubject<T>> list = this.l;
            int i = 1;
            while (!this.n) {
                boolean z = this.e;
                Object poll = mpscLinkedQueue.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof SubjectWork;
                if (z && (z2 || z3)) {
                    mpscLinkedQueue.clear();
                    Throwable th = this.f;
                    if (th != null) {
                        Iterator<UnicastSubject<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        Iterator<UnicastSubject<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    a();
                    list.clear();
                }
                if (z2) {
                    i = leave(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (z3) {
                    SubjectWork subjectWork = (SubjectWork) poll;
                    if (!subjectWork.b) {
                        list.remove(subjectWork.a);
                        subjectWork.a.onComplete();
                        if (list.isEmpty() && this.d) {
                            this.n = true;
                        }
                    } else if (!this.d) {
                        UnicastSubject<T> create = UnicastSubject.create(this.k);
                        list.add(create);
                        observer.onNext(create);
                        this.j.schedule(new CompletionTask(create), this.g, this.i);
                    }
                } else {
                    Iterator<UnicastSubject<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(poll);
                    }
                }
            }
            this.m.dispose();
            a();
            mpscLinkedQueue.clear();
            list.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.d = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.e = true;
            if (enter()) {
                b();
            }
            this.b.onComplete();
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f = th;
            this.e = true;
            if (enter()) {
                b();
            }
            this.b.onError(th);
            a();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (fastEnter()) {
                Iterator<UnicastSubject<T>> it = this.l.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.c.offer(t);
                if (!enter()) {
                    return;
                }
            }
            b();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.m, disposable)) {
                this.m = disposable;
                this.b.onSubscribe(this);
                if (this.d) {
                    return;
                }
                UnicastSubject<T> create = UnicastSubject.create(this.k);
                this.l.add(create);
                this.b.onNext(create);
                this.j.schedule(new CompletionTask(create), this.g, this.i);
                Scheduler.Worker worker = this.j;
                long j = this.h;
                worker.schedulePeriodically(this, j, j, this.i);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            SubjectWork subjectWork = new SubjectWork(UnicastSubject.create(this.k), true);
            if (!this.d) {
                this.c.offer(subjectWork);
            }
            if (enter()) {
                b();
            }
        }
    }

    public ObservableWindowTimed(ObservableSource<T> observableSource, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, long j3, int i, boolean z) {
        super(observableSource);
        this.b = j;
        this.c = j2;
        this.d = timeUnit;
        this.e = scheduler;
        this.f = j3;
        this.g = i;
        this.h = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        long j = this.b;
        long j2 = this.c;
        if (j != j2) {
            this.a.subscribe(new WindowSkipObserver(serializedObserver, j, j2, this.d, this.e.createWorker(), this.g));
            return;
        }
        long j3 = this.f;
        if (j3 == Long.MAX_VALUE) {
            this.a.subscribe(new WindowExactUnboundedObserver(serializedObserver, j, this.d, this.e, this.g));
        } else {
            this.a.subscribe(new WindowExactBoundedObserver(serializedObserver, j, this.d, this.e, this.g, j3, this.h));
        }
    }
}
