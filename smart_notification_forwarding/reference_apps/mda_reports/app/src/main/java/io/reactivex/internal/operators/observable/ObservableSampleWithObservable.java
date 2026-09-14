package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableSampleWithObservable<T> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<?> b;
    final boolean c;

    /* loaded from: classes3.dex */
    static final class SampleMainEmitLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        final AtomicInteger e;
        volatile boolean f;

        SampleMainEmitLast(Observer<? super T> observer, ObservableSource<?> observableSource) {
            super(observer, observableSource);
            this.e = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void a() {
            this.f = true;
            if (this.e.getAndIncrement() == 0) {
                c();
                this.a.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void b() {
            this.f = true;
            if (this.e.getAndIncrement() == 0) {
                c();
                this.a.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void d() {
            if (this.e.getAndIncrement() != 0) {
                return;
            }
            do {
                boolean z = this.f;
                c();
                if (z) {
                    this.a.onComplete();
                    return;
                }
            } while (this.e.decrementAndGet() != 0);
        }
    }

    /* loaded from: classes3.dex */
    static final class SampleMainNoLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        SampleMainNoLast(Observer<? super T> observer, ObservableSource<?> observableSource) {
            super(observer, observableSource);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void a() {
            this.a.onComplete();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void b() {
            this.a.onComplete();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void d() {
            c();
        }
    }

    /* loaded from: classes3.dex */
    static abstract class SampleMainObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -3517602651313910099L;
        final Observer<? super T> a;
        final ObservableSource<?> b;
        final AtomicReference<Disposable> c = new AtomicReference<>();
        Disposable d;

        SampleMainObserver(Observer<? super T> observer, ObservableSource<?> observableSource) {
            this.a = observer;
            this.b = observableSource;
        }

        abstract void a();

        boolean a(Disposable disposable) {
            return DisposableHelper.setOnce(this.c, disposable);
        }

        abstract void b();

        void c() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.a.onNext(andSet);
            }
        }

        public void complete() {
            this.d.dispose();
            b();
        }

        abstract void d();

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.c);
            this.d.dispose();
        }

        public void error(Throwable th) {
            this.d.dispose();
            this.a.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.c.get() == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.dispose(this.c);
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.c);
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.a.onSubscribe(this);
                if (this.c.get() == null) {
                    this.b.subscribe(new SamplerObserver(this));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class SamplerObserver<T> implements Observer<Object> {
        final SampleMainObserver<T> a;

        SamplerObserver(SampleMainObserver<T> sampleMainObserver) {
            this.a = sampleMainObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.a.complete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.a.error(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            this.a.d();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.a.a(disposable);
        }
    }

    public ObservableSampleWithObservable(ObservableSource<T> observableSource, ObservableSource<?> observableSource2, boolean z) {
        super(observableSource);
        this.b = observableSource2;
        this.c = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        ObservableSource<T> observableSource;
        Observer<? super T> sampleMainNoLast;
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        if (this.c) {
            observableSource = this.a;
            sampleMainNoLast = new SampleMainEmitLast<>(serializedObserver, this.b);
        } else {
            observableSource = this.a;
            sampleMainNoLast = new SampleMainNoLast<>(serializedObserver, this.b);
        }
        observableSource.subscribe(sampleMainNoLast);
    }
}
