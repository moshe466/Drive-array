package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class ObservableTakeLastTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final long b;
    final long c;
    final TimeUnit d;
    final Scheduler e;
    final int f;
    final boolean g;

    /* loaded from: classes3.dex */
    static final class TakeLastTimedObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -5677354903406201275L;
        final Observer<? super T> a;
        final long b;
        final long c;
        final TimeUnit d;
        final Scheduler e;
        final SpscLinkedArrayQueue<Object> f;
        final boolean g;
        Disposable h;
        volatile boolean i;
        Throwable j;

        TakeLastTimedObserver(Observer<? super T> observer, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
            this.a = observer;
            this.b = j;
            this.c = j2;
            this.d = timeUnit;
            this.e = scheduler;
            this.f = new SpscLinkedArrayQueue<>(i);
            this.g = z;
        }

        void a() {
            Throwable th;
            if (compareAndSet(false, true)) {
                Observer<? super T> observer = this.a;
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f;
                boolean z = this.g;
                while (!this.i) {
                    if (!z && (th = this.j) != null) {
                        spscLinkedArrayQueue.clear();
                        observer.onError(th);
                        return;
                    }
                    Object poll = spscLinkedArrayQueue.poll();
                    if (poll == null) {
                        Throwable th2 = this.j;
                        if (th2 != null) {
                            observer.onError(th2);
                            return;
                        } else {
                            observer.onComplete();
                            return;
                        }
                    }
                    Object poll2 = spscLinkedArrayQueue.poll();
                    if (((Long) poll).longValue() >= this.e.now(this.d) - this.c) {
                        observer.onNext(poll2);
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.i) {
                return;
            }
            this.i = true;
            this.h.dispose();
            if (compareAndSet(false, true)) {
                this.f.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.i;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.j = th;
            a();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f;
            long now = this.e.now(this.d);
            long j = this.c;
            long j2 = this.b;
            boolean z = j2 == Long.MAX_VALUE;
            spscLinkedArrayQueue.offer(Long.valueOf(now), t);
            while (!spscLinkedArrayQueue.isEmpty()) {
                if (((Long) spscLinkedArrayQueue.peek()).longValue() > now - j && (z || (spscLinkedArrayQueue.size() >> 1) <= j2)) {
                    return;
                }
                spscLinkedArrayQueue.poll();
                spscLinkedArrayQueue.poll();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.h, disposable)) {
                this.h = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableTakeLastTimed(ObservableSource<T> observableSource, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
        super(observableSource);
        this.b = j;
        this.c = j2;
        this.d = timeUnit;
        this.e = scheduler;
        this.f = i;
        this.g = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.a.subscribe(new TakeLastTimedObserver(observer, this.b, this.c, this.d, this.e, this.f, this.g));
    }
}
