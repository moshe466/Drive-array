package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableWindowBoundarySelector<T, B, V> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final ObservableSource<B> b;
    final Function<? super B, ? extends ObservableSource<V>> c;
    final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class OperatorWindowBoundaryCloseObserver<T, V> extends DisposableObserver<V> {
        final WindowBoundaryMainObserver<T, ?, V> b;
        final UnicastSubject<T> c;
        boolean d;

        OperatorWindowBoundaryCloseObserver(WindowBoundaryMainObserver<T, ?, V> windowBoundaryMainObserver, UnicastSubject<T> unicastSubject) {
            this.b = windowBoundaryMainObserver;
            this.c = unicastSubject;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.d) {
                return;
            }
            this.d = true;
            this.b.a((OperatorWindowBoundaryCloseObserver) this);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.onError(th);
            } else {
                this.d = true;
                this.b.a(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(V v) {
            dispose();
            onComplete();
        }
    }

    /* loaded from: classes3.dex */
    static final class OperatorWindowBoundaryOpenObserver<T, B> extends DisposableObserver<B> {
        final WindowBoundaryMainObserver<T, B, ?> b;

        OperatorWindowBoundaryOpenObserver(WindowBoundaryMainObserver<T, B, ?> windowBoundaryMainObserver) {
            this.b = windowBoundaryMainObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.b.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.b.a(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(B b) {
            this.b.a((WindowBoundaryMainObserver<T, B, ?>) b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class WindowBoundaryMainObserver<T, B, V> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {
        final ObservableSource<B> g;
        final Function<? super B, ? extends ObservableSource<V>> h;
        final int i;
        final CompositeDisposable j;
        Disposable k;
        final AtomicReference<Disposable> l;
        final List<UnicastSubject<T>> m;
        final AtomicLong n;

        WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, ObservableSource<B> observableSource, Function<? super B, ? extends ObservableSource<V>> function, int i) {
            super(observer, new MpscLinkedQueue());
            this.l = new AtomicReference<>();
            this.n = new AtomicLong();
            this.g = observableSource;
            this.h = function;
            this.i = i;
            this.j = new CompositeDisposable();
            this.m = new ArrayList();
            this.n.lazySet(1L);
        }

        void a() {
            this.j.dispose();
            DisposableHelper.dispose(this.l);
        }

        void a(OperatorWindowBoundaryCloseObserver<T, V> operatorWindowBoundaryCloseObserver) {
            this.j.delete(operatorWindowBoundaryCloseObserver);
            this.c.offer(new WindowOperation(operatorWindowBoundaryCloseObserver.c, null));
            if (enter()) {
                b();
            }
        }

        void a(B b) {
            this.c.offer(new WindowOperation(null, b));
            if (enter()) {
                b();
            }
        }

        void a(Throwable th) {
            this.k.dispose();
            this.j.dispose();
            onError(th);
        }

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public void accept(Observer<? super Observable<T>> observer, Object obj) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        void b() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.c;
            Observer<? super V> observer = this.b;
            List<UnicastSubject<T>> list = this.m;
            int i = 1;
            while (true) {
                boolean z = this.e;
                Object poll = mpscLinkedQueue.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    a();
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
                    list.clear();
                    return;
                }
                if (z2) {
                    i = leave(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (poll instanceof WindowOperation) {
                    WindowOperation windowOperation = (WindowOperation) poll;
                    UnicastSubject<T> unicastSubject = windowOperation.a;
                    if (unicastSubject != null) {
                        if (list.remove(unicastSubject)) {
                            windowOperation.a.onComplete();
                            if (this.n.decrementAndGet() == 0) {
                                a();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.d) {
                        UnicastSubject<T> create = UnicastSubject.create(this.i);
                        list.add(create);
                        observer.onNext(create);
                        try {
                            ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.h.apply(windowOperation.b), "The ObservableSource supplied is null");
                            OperatorWindowBoundaryCloseObserver operatorWindowBoundaryCloseObserver = new OperatorWindowBoundaryCloseObserver(this, create);
                            if (this.j.add(operatorWindowBoundaryCloseObserver)) {
                                this.n.getAndIncrement();
                                observableSource.subscribe(operatorWindowBoundaryCloseObserver);
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            this.d = true;
                            observer.onError(th2);
                        }
                    }
                } else {
                    Iterator<UnicastSubject<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(NotificationLite.getValue(poll));
                    }
                }
            }
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
            if (this.e) {
                return;
            }
            this.e = true;
            if (enter()) {
                b();
            }
            if (this.n.decrementAndGet() == 0) {
                this.j.dispose();
            }
            this.b.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.e) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.f = th;
            this.e = true;
            if (enter()) {
                b();
            }
            if (this.n.decrementAndGet() == 0) {
                this.j.dispose();
            }
            this.b.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (fastEnter()) {
                Iterator<UnicastSubject<T>> it = this.m.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
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
            if (DisposableHelper.validate(this.k, disposable)) {
                this.k = disposable;
                this.b.onSubscribe(this);
                if (this.d) {
                    return;
                }
                OperatorWindowBoundaryOpenObserver operatorWindowBoundaryOpenObserver = new OperatorWindowBoundaryOpenObserver(this);
                if (this.l.compareAndSet(null, operatorWindowBoundaryOpenObserver)) {
                    this.n.getAndIncrement();
                    this.g.subscribe(operatorWindowBoundaryOpenObserver);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class WindowOperation<T, B> {
        final UnicastSubject<T> a;
        final B b;

        WindowOperation(UnicastSubject<T> unicastSubject, B b) {
            this.a = unicastSubject;
            this.b = b;
        }
    }

    public ObservableWindowBoundarySelector(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Function<? super B, ? extends ObservableSource<V>> function, int i) {
        super(observableSource);
        this.b = observableSource2;
        this.c = function;
        this.d = i;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        this.a.subscribe(new WindowBoundaryMainObserver(new SerializedObserver(observer), this.b, this.c, this.d));
    }
}
