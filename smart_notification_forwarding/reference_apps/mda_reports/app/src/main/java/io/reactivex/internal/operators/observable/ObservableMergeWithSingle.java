package io.reactivex.internal.operators.observable;

import android.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ObservableMergeWithSingle<T> extends AbstractObservableWithUpstream<T, T> {
    final SingleSource<? extends T> b;

    /* loaded from: classes3.dex */
    static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -4592979584110982903L;
        final Observer<? super T> a;
        final AtomicReference<Disposable> b = new AtomicReference<>();
        final OtherObserver<T> c = new OtherObserver<>(this);
        final AtomicThrowable d = new AtomicThrowable();
        volatile SimplePlainQueue<T> e;
        T f;
        volatile boolean g;
        volatile boolean h;
        volatile int i;

        /* loaded from: classes3.dex */
        static final class OtherObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
            private static final long serialVersionUID = -2935427570954647017L;
            final MergeWithObserver<T> a;

            OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.a = mergeWithObserver;
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                this.a.a(th);
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(T t) {
                this.a.a((MergeWithObserver<T>) t);
            }
        }

        MergeWithObserver(Observer<? super T> observer) {
            this.a = observer;
        }

        void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        void a(T t) {
            if (compareAndSet(0, 1)) {
                this.a.onNext(t);
                this.i = 2;
            } else {
                this.f = t;
                this.i = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        void a(Throwable th) {
            if (!this.d.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                DisposableHelper.dispose(this.b);
                a();
            }
        }

        void b() {
            Observer<? super T> observer = this.a;
            int i = 1;
            while (!this.g) {
                if (this.d.get() != null) {
                    this.f = null;
                    this.e = null;
                    observer.onError(this.d.terminate());
                    return;
                }
                int i2 = this.i;
                if (i2 == 1) {
                    T t = this.f;
                    this.f = null;
                    this.i = 2;
                    observer.onNext(t);
                    i2 = 2;
                }
                boolean z = this.h;
                SimplePlainQueue<T> simplePlainQueue = this.e;
                R.bool poll = simplePlainQueue != null ? simplePlainQueue.poll() : null;
                boolean z2 = poll == null;
                if (z && z2 && i2 == 2) {
                    this.e = null;
                    observer.onComplete();
                    return;
                } else if (z2) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    observer.onNext(poll);
                }
            }
            this.f = null;
            this.e = null;
        }

        SimplePlainQueue<T> c() {
            SimplePlainQueue<T> simplePlainQueue = this.e;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscLinkedArrayQueue spscLinkedArrayQueue = new SpscLinkedArrayQueue(Observable.bufferSize());
            this.e = spscLinkedArrayQueue;
            return spscLinkedArrayQueue;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.g = true;
            DisposableHelper.dispose(this.b);
            DisposableHelper.dispose(this.c);
            if (getAndIncrement() == 0) {
                this.e = null;
                this.f = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.b.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.h = true;
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.d.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                DisposableHelper.dispose(this.b);
                a();
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (compareAndSet(0, 1)) {
                this.a.onNext(t);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                c().offer(t);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.b, disposable);
        }
    }

    public ObservableMergeWithSingle(Observable<T> observable, SingleSource<? extends T> singleSource) {
        super(observable);
        this.b = singleSource;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.onSubscribe(mergeWithObserver);
        this.a.subscribe(mergeWithObserver);
        this.b.subscribe(mergeWithObserver.c);
    }
}
