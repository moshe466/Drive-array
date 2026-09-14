package io.reactivex.internal.operators.mixed;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Experimental
/* loaded from: classes2.dex */
public final class ObservableSwitchMapMaybe<T, R> extends Observable<R> {
    final Observable<T> a;
    final Function<? super T, ? extends MaybeSource<? extends R>> b;
    final boolean c;

    /* loaded from: classes2.dex */
    static final class SwitchMapMaybeMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        static final SwitchMapMaybeObserver<Object> i = new SwitchMapMaybeObserver<>(null);
        private static final long serialVersionUID = -5402190102429853762L;
        final Observer<? super R> a;
        final Function<? super T, ? extends MaybeSource<? extends R>> b;
        final boolean c;
        final AtomicThrowable d = new AtomicThrowable();
        final AtomicReference<SwitchMapMaybeObserver<R>> e = new AtomicReference<>();
        Disposable f;
        volatile boolean g;
        volatile boolean h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public static final class SwitchMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            final SwitchMapMaybeMainObserver<?, R> a;
            volatile R b;

            SwitchMapMaybeObserver(SwitchMapMaybeMainObserver<?, R> switchMapMaybeMainObserver) {
                this.a = switchMapMaybeMainObserver;
            }

            void a() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.a.a(this);
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                this.a.a(this, th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(R r) {
                this.b = r;
                this.a.b();
            }
        }

        SwitchMapMaybeMainObserver(Observer<? super R> observer, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
            this.a = observer;
            this.b = function;
            this.c = z;
        }

        void a() {
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver = (SwitchMapMaybeObserver) this.e.getAndSet(i);
            if (switchMapMaybeObserver == null || switchMapMaybeObserver == i) {
                return;
            }
            switchMapMaybeObserver.a();
        }

        void a(SwitchMapMaybeObserver<R> switchMapMaybeObserver) {
            if (this.e.compareAndSet(switchMapMaybeObserver, null)) {
                b();
            }
        }

        void a(SwitchMapMaybeObserver<R> switchMapMaybeObserver, Throwable th) {
            if (!this.e.compareAndSet(switchMapMaybeObserver, null) || !this.d.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (!this.c) {
                this.f.dispose();
                a();
            }
            b();
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super R> observer = this.a;
            AtomicThrowable atomicThrowable = this.d;
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.e;
            int i2 = 1;
            while (!this.h) {
                if (atomicThrowable.get() != null && !this.c) {
                    observer.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z = this.g;
                SwitchMapMaybeObserver<R> switchMapMaybeObserver = atomicReference.get();
                boolean z2 = switchMapMaybeObserver == null;
                if (z && z2) {
                    Throwable terminate = atomicThrowable.terminate();
                    if (terminate != null) {
                        observer.onError(terminate);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                }
                if (z2 || switchMapMaybeObserver.b == null) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    atomicReference.compareAndSet(switchMapMaybeObserver, null);
                    observer.onNext(switchMapMaybeObserver.b);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.h = true;
            this.f.dispose();
            a();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.h;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.g = true;
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.d.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            if (!this.c) {
                a();
            }
            this.g = true;
            b();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            SwitchMapMaybeObserver<R> switchMapMaybeObserver;
            SwitchMapMaybeObserver<R> switchMapMaybeObserver2 = this.e.get();
            if (switchMapMaybeObserver2 != null) {
                switchMapMaybeObserver2.a();
            }
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.requireNonNull(this.b.apply(t), "The mapper returned a null MaybeSource");
                SwitchMapMaybeObserver<R> switchMapMaybeObserver3 = new SwitchMapMaybeObserver<>(this);
                do {
                    switchMapMaybeObserver = this.e.get();
                    if (switchMapMaybeObserver == i) {
                        return;
                    }
                } while (!this.e.compareAndSet(switchMapMaybeObserver, switchMapMaybeObserver3));
                maybeSource.subscribe(switchMapMaybeObserver3);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.f.dispose();
                this.e.getAndSet(i);
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f, disposable)) {
                this.f = disposable;
                this.a.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMapMaybe(Observable<T> observable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        this.a = observable;
        this.b = function;
        this.c = z;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        if (ScalarXMapZHelper.a(this.a, this.b, observer)) {
            return;
        }
        this.a.subscribe(new SwitchMapMaybeMainObserver(observer, this.b, this.c));
    }
}
