package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;

/* loaded from: classes3.dex */
public final class SingleContains<T> extends io.reactivex.Single<Boolean> {
    final SingleSource<T> a;
    final Object b;
    final BiPredicate<Object, Object> c;

    /* loaded from: classes3.dex */
    final class Single implements SingleObserver<T> {
        private final SingleObserver<? super Boolean> s;

        Single(SingleObserver<? super Boolean> singleObserver) {
            this.s = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.s.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.s.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            try {
                this.s.onSuccess(Boolean.valueOf(SingleContains.this.c.test(t, SingleContains.this.b)));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.s.onError(th);
            }
        }
    }

    public SingleContains(SingleSource<T> singleSource, Object obj, BiPredicate<Object, Object> biPredicate) {
        this.a = singleSource;
        this.b = obj;
        this.c = biPredicate;
    }

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.a.subscribe(new Single(singleObserver));
    }
}
