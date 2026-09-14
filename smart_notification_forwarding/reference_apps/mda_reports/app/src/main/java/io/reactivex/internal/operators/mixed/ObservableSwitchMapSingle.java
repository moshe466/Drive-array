package io.reactivex.internal.operators.mixed;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
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
public final class ObservableSwitchMapSingle<T, R> extends Observable<R> {
    final Observable<T> a;
    final Function<? super T, ? extends SingleSource<? extends R>> b;
    final boolean c;

    /* loaded from: classes2.dex */
    static final class SwitchMapSingleMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        static final SwitchMapSingleObserver<Object> i = new SwitchMapSingleObserver<>(null);
        private static final long serialVersionUID = -5402190102429853762L;
        final Observer<? super R> a;
        final Function<? super T, ? extends SingleSource<? extends R>> b;
        final boolean c;
        final AtomicThrowable d = new AtomicThrowable();
        final AtomicReference<SwitchMapSingleObserver<R>> e = new AtomicReference<>();
        Disposable f;
        volatile boolean g;
        volatile boolean h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public static final class SwitchMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            final SwitchMapSingleMainObserver<?, R> a;
            volatile R b;

            SwitchMapSingleObserver(SwitchMapSingleMainObserver<?, R> switchMapSingleMainObserver) {
                this.a = switchMapSingleMainObserver;
            }

            void a() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                this.a.a(this, th);
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(R r) {
                this.b = r;
                this.a.b();
            }
        }

        SwitchMapSingleMainObserver(Observer<? super R> observer, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
            this.a = observer;
            this.b = function;
            this.c = z;
        }

        void a() {
            SwitchMapSingleObserver<Object> switchMapSingleObserver = (SwitchMapSingleObserver) this.e.getAndSet(i);
            if (switchMapSingleObserver == null || switchMapSingleObserver == i) {
                return;
            }
            switchMapSingleObserver.a();
        }

        void a(SwitchMapSingleObserver<R> switchMapSingleObserver, Throwable th) {
            if (!this.e.compareAndSet(switchMapSingleObserver, null) || !this.d.addThrowable(th)) {
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
            AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.e;
            int i2 = 1;
            while (!this.h) {
                if (atomicThrowable.get() != null && !this.c) {
                    observer.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z = this.g;
                SwitchMapSingleObserver<R> switchMapSingleObserver = atomicReference.get();
                boolean z2 = switchMapSingleObserver == null;
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
                if (z2 || switchMapSingleObserver.b == null) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    atomicReference.compareAndSet(switchMapSingleObserver, null);
                    observer.onNext(switchMapSingleObserver.b);
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
            SwitchMapSingleObserver<R> switchMapSingleObserver;
            SwitchMapSingleObserver<R> switchMapSingleObserver2 = this.e.get();
            if (switchMapSingleObserver2 != null) {
                switchMapSingleObserver2.a();
            }
            try {
                SingleSource singleSource = (SingleSource) ObjectHelper.requireNonNull(this.b.apply(t), "The mapper returned a null SingleSource");
                SwitchMapSingleObserver<R> switchMapSingleObserver3 = new SwitchMapSingleObserver<>(this);
                do {
                    switchMapSingleObserver = this.e.get();
                    if (switchMapSingleObserver == i) {
                        return;
                    }
                } while (!this.e.compareAndSet(switchMapSingleObserver, switchMapSingleObserver3));
                singleSource.subscribe(switchMapSingleObserver3);
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

    public ObservableSwitchMapSingle(Observable<T> observable, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        this.a = observable;
        this.b = function;
        this.c = z;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        if (ScalarXMapZHelper.b(this.a, this.b, observer)) {
            return;
        }
        this.a.subscribe(new SwitchMapSingleMainObserver(observer, this.b, this.c));
    }
}
