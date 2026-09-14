package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes3.dex */
public final class ObservableObserveOn<T> extends AbstractObservableWithUpstream<T, T> {
    final Scheduler b;
    final boolean c;
    final int d;

    /* loaded from: classes3.dex */
    static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        final Observer<? super T> a;
        final Scheduler.Worker b;
        final boolean c;
        final int d;
        SimpleQueue<T> e;
        Disposable f;
        Throwable g;
        volatile boolean h;
        volatile boolean i;
        int j;
        boolean k;

        ObserveOnObserver(Observer<? super T> observer, Scheduler.Worker worker, boolean z, int i) {
            this.a = observer;
            this.b = worker;
            this.c = z;
            this.d = i;
        }

        void a() {
            int i = 1;
            while (!this.i) {
                boolean z = this.h;
                Throwable th = this.g;
                if (this.c || !z || th == null) {
                    this.a.onNext(null);
                    if (z) {
                        Throwable th2 = this.g;
                        if (th2 != null) {
                            this.a.onError(th2);
                        } else {
                            this.a.onComplete();
                        }
                    } else {
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    }
                } else {
                    this.a.onError(th);
                }
                this.b.dispose();
                return;
            }
        }

        boolean a(boolean z, boolean z2, Observer<? super T> observer) {
            if (this.i) {
                this.e.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.g;
            if (this.c) {
                if (!z2) {
                    return false;
                }
                if (th != null) {
                    observer.onError(th);
                } else {
                    observer.onComplete();
                }
                this.b.dispose();
                return true;
            }
            if (th != null) {
                this.e.clear();
                observer.onError(th);
                this.b.dispose();
                return true;
            }
            if (!z2) {
                return false;
            }
            observer.onComplete();
            this.b.dispose();
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
        
            r3 = addAndGet(-r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
        
            if (r3 != 0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void b() {
            /*
                r7 = this;
                io.reactivex.internal.fuseable.SimpleQueue<T> r0 = r7.e
                io.reactivex.Observer<? super T> r1 = r7.a
                r2 = 1
                r3 = 1
            L6:
                boolean r4 = r7.h
                boolean r5 = r0.isEmpty()
                boolean r4 = r7.a(r4, r5, r1)
                if (r4 == 0) goto L13
                return
            L13:
                boolean r4 = r7.h
                java.lang.Object r5 = r0.poll()     // Catch: java.lang.Throwable -> L33
                if (r5 != 0) goto L1d
                r6 = 1
                goto L1e
            L1d:
                r6 = 0
            L1e:
                boolean r4 = r7.a(r4, r6, r1)
                if (r4 == 0) goto L25
                return
            L25:
                if (r6 == 0) goto L2f
                int r3 = -r3
                int r3 = r7.addAndGet(r3)
                if (r3 != 0) goto L6
                return
            L2f:
                r1.onNext(r5)
                goto L13
            L33:
                r2 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r2)
                io.reactivex.disposables.Disposable r3 = r7.f
                r3.dispose()
                r0.clear()
                r1.onError(r2)
                io.reactivex.Scheduler$Worker r0 = r7.b
                r0.dispose()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableObserveOn.ObserveOnObserver.b():void");
        }

        void c() {
            if (getAndIncrement() == 0) {
                this.b.schedule(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.e.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.i) {
                return;
            }
            this.i = true;
            this.f.dispose();
            this.b.dispose();
            if (getAndIncrement() == 0) {
                this.e.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.i;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.e.isEmpty();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.h) {
                return;
            }
            this.h = true;
            c();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.h) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.g = th;
            this.h = true;
            c();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.h) {
                return;
            }
            if (this.j != 2) {
                this.e.offer(t);
            }
            c();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(7);
                    if (requestFusion == 1) {
                        this.j = requestFusion;
                        this.e = queueDisposable;
                        this.h = true;
                        this.a.onSubscribe(this);
                        c();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.j = requestFusion;
                        this.e = queueDisposable;
                        this.a.onSubscribe(this);
                        return;
                    }
                }
                this.e = new SpscLinkedArrayQueue(this.d);
                this.a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public T poll() {
            return this.e.poll();
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.k = true;
            return 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.k) {
                a();
            } else {
                b();
            }
        }
    }

    public ObservableObserveOn(ObservableSource<T> observableSource, Scheduler scheduler, boolean z, int i) {
        super(observableSource);
        this.b = scheduler;
        this.c = z;
        this.d = i;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        Scheduler scheduler = this.b;
        if (scheduler instanceof TrampolineScheduler) {
            this.a.subscribe(observer);
        } else {
            this.a.subscribe(new ObserveOnObserver(observer, scheduler.createWorker(), this.c, this.d));
        }
    }
}
