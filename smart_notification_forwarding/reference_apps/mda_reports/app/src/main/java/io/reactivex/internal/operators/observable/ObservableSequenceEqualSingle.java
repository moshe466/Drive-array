package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class ObservableSequenceEqualSingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {
    final ObservableSource<? extends T> a;
    final ObservableSource<? extends T> b;
    final BiPredicate<? super T, ? super T> c;
    final int d;

    /* loaded from: classes3.dex */
    static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = -6178010334400373240L;
        final SingleObserver<? super Boolean> a;
        final BiPredicate<? super T, ? super T> b;
        final ArrayCompositeDisposable c;
        final ObservableSource<? extends T> d;
        final ObservableSource<? extends T> e;
        final EqualObserver<T>[] f;
        volatile boolean g;
        T h;
        T i;

        EqualCoordinator(SingleObserver<? super Boolean> singleObserver, int i, ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
            this.a = singleObserver;
            this.d = observableSource;
            this.e = observableSource2;
            this.b = biPredicate;
            this.f = r3;
            EqualObserver<T>[] equalObserverArr = {new EqualObserver<>(this, 0, i), new EqualObserver<>(this, 1, i)};
            this.c = new ArrayCompositeDisposable(2);
        }

        void a() {
            Throwable th;
            Throwable th2;
            if (getAndIncrement() != 0) {
                return;
            }
            EqualObserver<T>[] equalObserverArr = this.f;
            EqualObserver<T> equalObserver = equalObserverArr[0];
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = equalObserver.b;
            EqualObserver<T> equalObserver2 = equalObserverArr[1];
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue2 = equalObserver2.b;
            int i = 1;
            while (!this.g) {
                boolean z = equalObserver.d;
                if (z && (th2 = equalObserver.e) != null) {
                    a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                    this.a.onError(th2);
                    return;
                }
                boolean z2 = equalObserver2.d;
                if (z2 && (th = equalObserver2.e) != null) {
                    a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                    this.a.onError(th);
                    return;
                }
                if (this.h == null) {
                    this.h = spscLinkedArrayQueue.poll();
                }
                boolean z3 = this.h == null;
                if (this.i == null) {
                    this.i = spscLinkedArrayQueue2.poll();
                }
                boolean z4 = this.i == null;
                if (z && z2 && z3 && z4) {
                    this.a.onSuccess(true);
                    return;
                }
                if (z && z2 && z3 != z4) {
                    a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                    this.a.onSuccess(false);
                    return;
                }
                if (!z3 && !z4) {
                    try {
                        if (!this.b.test(this.h, this.i)) {
                            a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                            this.a.onSuccess(false);
                            return;
                        } else {
                            this.h = null;
                            this.i = null;
                        }
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                        this.a.onError(th3);
                        return;
                    }
                }
                if (z3 || z4) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
            spscLinkedArrayQueue.clear();
            spscLinkedArrayQueue2.clear();
        }

        void a(SpscLinkedArrayQueue<T> spscLinkedArrayQueue, SpscLinkedArrayQueue<T> spscLinkedArrayQueue2) {
            this.g = true;
            spscLinkedArrayQueue.clear();
            spscLinkedArrayQueue2.clear();
        }

        boolean a(Disposable disposable, int i) {
            return this.c.setResource(i, disposable);
        }

        void b() {
            EqualObserver<T>[] equalObserverArr = this.f;
            this.d.subscribe(equalObserverArr[0]);
            this.e.subscribe(equalObserverArr[1]);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.g) {
                return;
            }
            this.g = true;
            this.c.dispose();
            if (getAndIncrement() == 0) {
                EqualObserver<T>[] equalObserverArr = this.f;
                equalObserverArr[0].b.clear();
                equalObserverArr[1].b.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class EqualObserver<T> implements Observer<T> {
        final EqualCoordinator<T> a;
        final SpscLinkedArrayQueue<T> b;
        final int c;
        volatile boolean d;
        Throwable e;

        EqualObserver(EqualCoordinator<T> equalCoordinator, int i, int i2) {
            this.a = equalCoordinator;
            this.c = i;
            this.b = new SpscLinkedArrayQueue<>(i2);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.d = true;
            this.a.a();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.e = th;
            this.d = true;
            this.a.a();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.b.offer(t);
            this.a.a();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.a.a(disposable, this.c);
        }
    }

    public ObservableSequenceEqualSingle(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i) {
        this.a = observableSource;
        this.b = observableSource2;
        this.c = biPredicate;
        this.d = i;
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public Observable<Boolean> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableSequenceEqual(this.a, this.b, this.c, this.d));
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.d, this.a, this.b, this.c);
        singleObserver.onSubscribe(equalCoordinator);
        equalCoordinator.b();
    }
}
