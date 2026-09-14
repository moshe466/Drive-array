package io.reactivex.internal.operators.single;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class SingleFlatMapIterableObservable<T, R> extends Observable<R> {
    final SingleSource<T> a;
    final Function<? super T, ? extends Iterable<? extends R>> b;

    /* loaded from: classes3.dex */
    static final class FlatMapIterableObserver<T, R> extends BasicIntQueueDisposable<R> implements SingleObserver<T> {
        private static final long serialVersionUID = -8938804753851907758L;
        final Observer<? super R> a;
        final Function<? super T, ? extends Iterable<? extends R>> b;
        Disposable c;
        volatile Iterator<? extends R> d;
        volatile boolean e;
        boolean f;

        FlatMapIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.a = observer;
            this.b = function;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.d = null;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.e = true;
            this.c.dispose();
            this.c = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.e;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.d == null;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.c = DisposableHelper.DISPOSED;
            this.a.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.c, disposable)) {
                this.c = disposable;
                this.a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            Observer<? super R> observer = this.a;
            try {
                Iterator<? extends R> it = this.b.apply(t).iterator();
                if (!it.hasNext()) {
                    observer.onComplete();
                    return;
                }
                if (this.f) {
                    this.d = it;
                    observer.onNext(null);
                    observer.onComplete();
                    return;
                }
                while (!this.e) {
                    try {
                        observer.onNext(it.next());
                        if (this.e) {
                            return;
                        }
                        if (!it.hasNext()) {
                            observer.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        Exceptions.throwIfFatal(th);
                        observer.onError(th);
                        return;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                Exceptions.throwIfFatal(th);
                observer = this.a;
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public R poll() {
            Iterator<? extends R> it = this.d;
            if (it == null) {
                return null;
            }
            R r = (R) ObjectHelper.requireNonNull(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.d = null;
            }
            return r;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.f = true;
            return 2;
        }
    }

    public SingleFlatMapIterableObservable(SingleSource<T> singleSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.a = singleSource;
        this.b = function;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super R> observer) {
        this.a.subscribe(new FlatMapIterableObserver(observer, this.b));
    }
}
