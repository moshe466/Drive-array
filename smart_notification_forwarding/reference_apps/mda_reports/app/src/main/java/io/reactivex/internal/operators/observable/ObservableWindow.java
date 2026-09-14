package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class ObservableWindow<T> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final long b;
    final long c;
    final int d;

    /* loaded from: classes3.dex */
    static final class WindowExactObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -7481782523886138128L;
        final Observer<? super Observable<T>> a;
        final long b;
        final int c;
        long d;
        Disposable e;
        UnicastSubject<T> f;
        volatile boolean g;

        WindowExactObserver(Observer<? super Observable<T>> observer, long j, int i) {
            this.a = observer;
            this.b = j;
            this.c = i;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.g = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.g;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            UnicastSubject<T> unicastSubject = this.f;
            if (unicastSubject != null) {
                this.f = null;
                unicastSubject.onComplete();
            }
            this.a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            UnicastSubject<T> unicastSubject = this.f;
            if (unicastSubject != null) {
                this.f = null;
                unicastSubject.onError(th);
            }
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            UnicastSubject<T> unicastSubject = this.f;
            if (unicastSubject == null && !this.g) {
                unicastSubject = UnicastSubject.create(this.c, this);
                this.f = unicastSubject;
                this.a.onNext(unicastSubject);
            }
            if (unicastSubject != null) {
                unicastSubject.onNext(t);
                long j = this.d + 1;
                this.d = j;
                if (j >= this.b) {
                    this.d = 0L;
                    this.f = null;
                    unicastSubject.onComplete();
                    if (this.g) {
                        this.e.dispose();
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.e, disposable)) {
                this.e = disposable;
                this.a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.g) {
                this.e.dispose();
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class WindowSkipObserver<T> extends AtomicBoolean implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3366976432059579510L;
        final Observer<? super Observable<T>> a;
        final long b;
        final long c;
        final int d;
        long f;
        volatile boolean g;
        long h;
        Disposable i;
        final AtomicInteger j = new AtomicInteger();
        final ArrayDeque<UnicastSubject<T>> e = new ArrayDeque<>();

        WindowSkipObserver(Observer<? super Observable<T>> observer, long j, long j2, int i) {
            this.a = observer;
            this.b = j;
            this.c = j2;
            this.d = i;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.g = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.g;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.e;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onComplete();
            }
            this.a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.e;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onError(th);
            }
            this.a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.e;
            long j = this.f;
            long j2 = this.c;
            if (j % j2 == 0 && !this.g) {
                this.j.getAndIncrement();
                UnicastSubject<T> create = UnicastSubject.create(this.d, this);
                arrayDeque.offer(create);
                this.a.onNext(create);
            }
            long j3 = this.h + 1;
            Iterator<UnicastSubject<T>> it = arrayDeque.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            if (j3 >= this.b) {
                arrayDeque.poll().onComplete();
                if (arrayDeque.isEmpty() && this.g) {
                    this.i.dispose();
                    return;
                }
                j3 -= j2;
            }
            this.h = j3;
            this.f = j + 1;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.i, disposable)) {
                this.i = disposable;
                this.a.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.j.decrementAndGet() == 0 && this.g) {
                this.i.dispose();
            }
        }
    }

    public ObservableWindow(ObservableSource<T> observableSource, long j, long j2, int i) {
        super(observableSource);
        this.b = j;
        this.c = j2;
        this.d = i;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super Observable<T>> observer) {
        long j = this.b;
        long j2 = this.c;
        if (j == j2) {
            this.a.subscribe(new WindowExactObserver(observer, j, this.d));
        } else {
            this.a.subscribe(new WindowSkipObserver(observer, j, j2, this.d));
        }
    }
}
