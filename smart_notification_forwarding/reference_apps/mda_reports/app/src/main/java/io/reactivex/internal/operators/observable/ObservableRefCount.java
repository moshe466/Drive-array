package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableRefCount<T> extends Observable<T> {
    final ConnectableObservable<T> a;
    final int b;
    final long c;
    final TimeUnit d;
    final Scheduler e;
    RefConnection f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        private static final long serialVersionUID = -4552101107598366241L;
        final ObservableRefCount<?> a;
        Disposable b;
        long c;
        boolean d;

        RefConnection(ObservableRefCount<?> observableRefCount) {
            this.a = observableRefCount;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.c(this);
        }
    }

    /* loaded from: classes3.dex */
    static final class RefCountObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -7419642935409022375L;
        final Observer<? super T> a;
        final ObservableRefCount<T> b;
        final RefConnection c;
        Disposable d;

        RefCountObserver(Observer<? super T> observer, ObservableRefCount<T> observableRefCount, RefConnection refConnection) {
            this.a = observer;
            this.b = observableRefCount;
            this.c = refConnection;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.d.dispose();
            if (compareAndSet(false, true)) {
                this.b.a(this.c);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.d.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.b.b(this.c);
                this.a.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!compareAndSet(false, true)) {
                RxJavaPlugins.onError(th);
            } else {
                this.b.b(this.c);
                this.a.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableRefCount(ConnectableObservable<T> connectableObservable) {
        this(connectableObservable, 1, 0L, TimeUnit.NANOSECONDS, Schedulers.trampoline());
    }

    public ObservableRefCount(ConnectableObservable<T> connectableObservable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.a = connectableObservable;
        this.b = i;
        this.c = j;
        this.d = timeUnit;
        this.e = scheduler;
    }

    void a(RefConnection refConnection) {
        synchronized (this) {
            if (this.f == null) {
                return;
            }
            long j = refConnection.c - 1;
            refConnection.c = j;
            if (j == 0 && refConnection.d) {
                if (this.c == 0) {
                    c(refConnection);
                    return;
                }
                SequentialDisposable sequentialDisposable = new SequentialDisposable();
                refConnection.b = sequentialDisposable;
                sequentialDisposable.replace(this.e.scheduleDirect(refConnection, this.c, this.d));
            }
        }
    }

    void b(RefConnection refConnection) {
        synchronized (this) {
            if (this.f != null) {
                this.f = null;
                if (refConnection.b != null) {
                    refConnection.b.dispose();
                }
                if (this.a instanceof Disposable) {
                    ((Disposable) this.a).dispose();
                }
            }
        }
    }

    void c(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.c == 0 && refConnection == this.f) {
                this.f = null;
                DisposableHelper.dispose(refConnection);
                if (this.a instanceof Disposable) {
                    ((Disposable) this.a).dispose();
                }
            }
        }
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        RefConnection refConnection;
        boolean z;
        synchronized (this) {
            refConnection = this.f;
            if (refConnection == null) {
                refConnection = new RefConnection(this);
                this.f = refConnection;
            }
            long j = refConnection.c;
            if (j == 0 && refConnection.b != null) {
                refConnection.b.dispose();
            }
            long j2 = j + 1;
            refConnection.c = j2;
            z = true;
            if (refConnection.d || j2 != this.b) {
                z = false;
            } else {
                refConnection.d = true;
            }
        }
        this.a.subscribe(new RefCountObserver(observer, this, refConnection));
        if (z) {
            this.a.connect(refConnection);
        }
    }
}
