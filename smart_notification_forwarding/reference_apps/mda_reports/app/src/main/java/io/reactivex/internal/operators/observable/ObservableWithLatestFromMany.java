package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes3.dex */
public final class ObservableWithLatestFromMany<T, R> extends AbstractObservableWithUpstream<T, R> {

    @Nullable
    final ObservableSource<?>[] b;

    @Nullable
    final Iterable<? extends ObservableSource<?>> c;

    @NonNull
    final Function<? super Object[], R> d;

    /* loaded from: classes3.dex */
    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public R apply(T t) {
            return (R) ObjectHelper.requireNonNull(ObservableWithLatestFromMany.this.d.apply(new Object[]{t}), "The combiner returned a null value");
        }
    }

    /* loaded from: classes3.dex */
    static final class WithLatestFromObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1577321883966341961L;
        final Observer<? super R> a;
        final Function<? super Object[], R> b;
        final WithLatestInnerObserver[] c;
        final AtomicReferenceArray<Object> d;
        final AtomicReference<Disposable> e;
        final AtomicThrowable f;
        volatile boolean g;

        WithLatestFromObserver(Observer<? super R> observer, Function<? super Object[], R> function, int i) {
            this.a = observer;
            this.b = function;
            WithLatestInnerObserver[] withLatestInnerObserverArr = new WithLatestInnerObserver[i];
            for (int i2 = 0; i2 < i; i2++) {
                withLatestInnerObserverArr[i2] = new WithLatestInnerObserver(this, i2);
            }
            this.c = withLatestInnerObserverArr;
            this.d = new AtomicReferenceArray<>(i);
            this.e = new AtomicReference<>();
            this.f = new AtomicThrowable();
        }

        void a(int i) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.c;
            for (int i2 = 0; i2 < withLatestInnerObserverArr.length; i2++) {
                if (i2 != i) {
                    withLatestInnerObserverArr[i2].dispose();
                }
            }
        }

        void a(int i, Object obj) {
            this.d.set(i, obj);
        }

        void a(int i, Throwable th) {
            this.g = true;
            DisposableHelper.dispose(this.e);
            a(i);
            HalfSerializer.onError(this.a, th, this, this.f);
        }

        void a(int i, boolean z) {
            if (z) {
                return;
            }
            this.g = true;
            a(i);
            HalfSerializer.onComplete(this.a, this, this.f);
        }

        void a(ObservableSource<?>[] observableSourceArr, int i) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.c;
            AtomicReference<Disposable> atomicReference = this.e;
            for (int i2 = 0; i2 < i && !DisposableHelper.isDisposed(atomicReference.get()) && !this.g; i2++) {
                observableSourceArr[i2].subscribe(withLatestInnerObserverArr[i2]);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.e);
            for (WithLatestInnerObserver withLatestInnerObserver : this.c) {
                withLatestInnerObserver.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.e.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.g) {
                return;
            }
            this.g = true;
            a(-1);
            HalfSerializer.onComplete(this.a, this, this.f);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.g) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.g = true;
            a(-1);
            HalfSerializer.onError(this.a, th, this, this.f);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.g) {
                return;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.d;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            int i = 0;
            objArr[0] = t;
            while (i < length) {
                Object obj = atomicReferenceArray.get(i);
                if (obj == null) {
                    return;
                }
                i++;
                objArr[i] = obj;
            }
            try {
                HalfSerializer.onNext(this.a, ObjectHelper.requireNonNull(this.b.apply(objArr), "combiner returned a null value"), this, this.f);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.e, disposable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class WithLatestInnerObserver extends AtomicReference<Disposable> implements Observer<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        final WithLatestFromObserver<?, ?> a;
        final int b;
        boolean c;

        WithLatestInnerObserver(WithLatestFromObserver<?, ?> withLatestFromObserver, int i) {
            this.a = withLatestFromObserver;
            this.b = i;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.a.a(this.b, this.c);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.a.a(this.b, th);
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            if (!this.c) {
                this.c = true;
            }
            this.a.a(this.b, obj);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableWithLatestFromMany(@NonNull ObservableSource<T> observableSource, @NonNull Iterable<? extends ObservableSource<?>> iterable, @NonNull Function<? super Object[], R> function) {
        super(observableSource);
        this.b = null;
        this.c = iterable;
        this.d = function;
    }

    public ObservableWithLatestFromMany(@NonNull ObservableSource<T> observableSource, @NonNull ObservableSource<?>[] observableSourceArr, @NonNull Function<? super Object[], R> function) {
        super(observableSource);
        this.b = observableSourceArr;
        this.c = null;
        this.d = function;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        int length;
        ObservableSource<?>[] observableSourceArr = this.b;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            try {
                length = 0;
                for (ObservableSource<?> observableSource : this.c) {
                    if (length == observableSourceArr.length) {
                        observableSourceArr = (ObservableSource[]) Arrays.copyOf(observableSourceArr, (length >> 1) + length);
                    }
                    int i = length + 1;
                    observableSourceArr[length] = observableSource;
                    length = i;
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                EmptyDisposable.error(th, observer);
                return;
            }
        } else {
            length = observableSourceArr.length;
        }
        if (length == 0) {
            new ObservableMap(this.a, new SingletonArrayFunc()).subscribeActual(observer);
            return;
        }
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(observer, this.d, length);
        observer.onSubscribe(withLatestFromObserver);
        withLatestFromObserver.a(observableSourceArr, length);
        this.a.subscribe(withLatestFromObserver);
    }
}
